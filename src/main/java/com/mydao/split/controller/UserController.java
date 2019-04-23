package com.mydao.split.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mydao.split.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: redis-demo
 * @description: 用户信息
 * @author: Eyki
 * @create: 2019-03-20 18:11
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    ObjectMapper om = new ObjectMapper();
    @GetMapping("/getByUserId")
    public String getByUserId(@RequestParam Long id) throws Exception{
        return om.writeValueAsString(userService.selectByPrimaryKey(id));
    }
}
