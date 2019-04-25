package com.mydao.split.service.impl;

import com.mydao.split.dao.DataTransactionMapper;
import com.mydao.split.service.DataTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DataTransactionServiceImpl implements DataTransactionService {

    @Autowired
    private DataTransactionMapper dataTransactionMapper;

    @Override
    public int selectTotalTriffic(Map<String, Object> map) {
        return dataTransactionMapper.selectTotalTriffic(map);
    }
}
