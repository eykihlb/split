package com.mydao.split.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mydao.split.entity.SplitUser;
import com.mydao.split.service.DataJobService;
import com.mydao.split.service.DataTransactionService;
import com.mydao.split.utils.JDBCUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/triffic")
public class TrifficController {

    private static final Logger log = LoggerFactory.getLogger(TrifficController.class);

    @Autowired
    private DataTransactionService dataTransactionService;

    @Autowired
    private DataJobService dataJobService;

    private ObjectMapper om = new ObjectMapper();

    @GetMapping("/getAllTriffic")
    public String getAllTriffic(@RequestParam String todDate, @RequestParam String shiftNo, @RequestParam String netSiteNo, HttpSession session) throws Exception{
        SplitUser user = (SplitUser)session.getAttribute("user");
        Map<String,Object> paramMap = new HashMap<>();
        Map<String,Object> resultMap = new HashMap<>();
        paramMap.put("todDate",todDate);
        paramMap.put("shiftNo",shiftNo);
        paramMap.put("netSiteNo",netSiteNo);

        //中心交易流水记录数
        int centerTransactionTriffic = dataTransactionService.selectTotalTriffic(paramMap);
        //中心交接班记录交易记录数
        int centerJobTriffic = dataJobService.selectTotalTriffic(paramMap);
        //站交接班交易记录数
        int siteJobTriffic = 0;
        String sql = "select sum(TRAFFICTOTAL) as TRAFFICTOTAL from data_job t where 1 = 1 and to_char(t.toddate,'yyyy-MM-dd') = ? and t.shiftno = ? and t.netno||t.siteno = ?";
        PreparedStatement pstmt;
        try {
            Connection conn = JDBCUtil.getConn("192.168.0.200");
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, todDate);
            pstmt.setString(2, shiftNo);
            pstmt.setString(3, netSiteNo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                siteJobTriffic = rs.getInt("TRAFFICTOTAL");
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
            resultMap.put("status",0);
            resultMap.put("msg","JDBC Error!");
            return om.writeValueAsString(resultMap);
        }
        resultMap.put("centerTransactionTriffic",centerTransactionTriffic);
        resultMap.put("centerJobTriffic",centerJobTriffic);
        resultMap.put("siteJobTriffic",siteJobTriffic);
        resultMap.put("status",1);
        resultMap.put("msg","success!");

        return om.writeValueAsString(resultMap);
    }
}
