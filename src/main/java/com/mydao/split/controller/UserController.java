package com.mydao.split.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mydao.split.entity.SplitUser;
import com.mydao.split.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @program: redis-demo
 * @description: 用户信息
 * @author: Eyki
 * @create: 2019-03-20 18:11
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    ObjectMapper om = new ObjectMapper();

    @GetMapping("/getByUserId")
    public String getByUserId(@RequestParam String id) throws Exception{
        return om.writeValueAsString(userService.selectByPrimaryKey(id));
    }

    /**
     * Login
     * @param userName
     * @param passWord
     * @return
     * @throws Exception
     */
    @GetMapping("/login")
    public String login(@RequestParam String userName, @RequestParam String passWord, HttpSession session) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        SplitUser user = userService.getByUserName(userName);
        if (user!=null){
            if (user.getPassWord().equals(passWord)){
                resultMap.put("status",1);
                resultMap.put("msg","登陆成功！");
                resultMap.put("data",user);
                session.setAttribute("user",user);
            }else{
                resultMap.put("status",0);
                resultMap.put("msg","密码错误！");
            }
        }else{
            resultMap.put("status",0);
            resultMap.put("msg","用户名不存在！");
        }
        return om.writeValueAsString(resultMap);
    }

    @GetMapping("/loginout")
    public String loginout(HttpSession session) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        session.removeAttribute("user");
        resultMap.put("status",1);
        resultMap.put("msg","登出成功！");
        return om.writeValueAsString(resultMap);
    }
    /**
     * insert
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/insert")
    public String save(@RequestBody SplitUser user) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        user.setId(UUID.randomUUID().toString().replaceAll("-",""));
        try {
            if (userService.getByUserName(user.getUserName())!=null){
                resultMap.put("status",0);
                resultMap.put("msg","用户名已存在！");
                return om.writeValueAsString(resultMap);
            }
            userService.insertSelective(user);
            resultMap.put("status",1);
            resultMap.put("msg","保存成功！");
            resultMap.put("data",user);
        }catch (Exception e){
            log.error(e.getMessage());
            resultMap.put("status",0);
            resultMap.put("msg",e.getMessage());
        }
        return om.writeValueAsString(resultMap);
    }

    /**
     * delete
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping("/delete")
    public String delete(@RequestParam String id) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        try {
            if (userService.deleteByPrimaryKey(id)>0){
                resultMap.put("status",1);
                resultMap.put("msg","用户已移除！");
            }else{
                resultMap.put("status",0);
                resultMap.put("msg","用户不存在！");
            }
        }catch (Exception e){
            log.error(e.getMessage());
            resultMap.put("status",0);
            resultMap.put("msg","系统异常！");
        }
        return om.writeValueAsString(resultMap);
    }

    /**
     * userList
     * @param splitUser
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    public String findList(@RequestBody SplitUser splitUser) throws Exception{
        Map<String,Object> paramMap = new HashMap<>();
        Map<String,Object> resultMap = new HashMap<>();
        paramMap.put("page",splitUser.getPage());
        paramMap.put("limit",splitUser.getLimit());
        paramMap.put("nickName",splitUser.getNickName());
        paramMap.put("userType",splitUser.getUserType());
        paramMap.put("netSiteNo",splitUser.getNetSiteNo());
        Map<String,Object> map = userService.findList(paramMap);
        resultMap.put("status",1);
        resultMap.put("msg","success!");
        resultMap.put("data",map);
        return  om.writeValueAsString(resultMap);
    }
}
