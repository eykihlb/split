package com.mydao.split.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mydao.split.entity.DataTod;
import com.mydao.split.entity.SplitUser;
import com.mydao.split.service.DataTodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tod")
public class TodController {

    private static final Logger log = LoggerFactory.getLogger(TodController.class);

    @Autowired
    private DataTodService dataTodService;

    private ObjectMapper om = new ObjectMapper();

    @GetMapping("/getList")
    public String getList(HttpSession session, @RequestParam String todDate,@RequestParam String shiftNo) throws Exception{
        Map<String,Object> paramMap = new HashMap<>();
        Map<String,Object> resultMap = new HashMap<>();
        SplitUser user = (SplitUser)session.getAttribute("user");
        if (user==null){
            resultMap.put("status",0);
            resultMap.put("msg","未登陆或者登陆状态超时，请重新登陆！");
            return om.writeValueAsString(resultMap);
        }
        paramMap.put("todDate",todDate);
        paramMap.put("shiftNo",shiftNo);
        paramMap.put("netSiteNo",user.getNetSiteNo());

        List<DataTod> todList =  dataTodService.selectBySiteNoAndShiftNo(paramMap);
        resultMap.put("status",1);
        resultMap.put("msg","success");
        resultMap.put("data",todList);
        return om.writeValueAsString(resultMap);
    }
}
