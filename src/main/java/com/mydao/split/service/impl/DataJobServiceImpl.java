package com.mydao.split.service.impl;

import com.mydao.split.dao.DataJobMapper;
import com.mydao.split.service.DataJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DataJobServiceImpl implements DataJobService {

    @Autowired
    private DataJobMapper dataJobMapper;

    @Override
    public int selectTotalTriffic(Map<String, Object> map) {
        return dataJobMapper.selectTotalTriffic(map);
    }
}
