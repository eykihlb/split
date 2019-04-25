package com.mydao.split.service.impl;

import com.mydao.split.dao.DataTodMapper;
import com.mydao.split.entity.DataTod;
import com.mydao.split.service.DataTodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DataTodSeviceImpl implements DataTodService {

    private static final Logger log = LoggerFactory.getLogger(DataTodSeviceImpl.class);

    @Autowired
    private DataTodMapper dataTodMapper;

    @Override
    public List<DataTod> selectBySiteNoAndShiftNo(Map<String, Object> map) {
        return dataTodMapper.selectBySiteNoAndShiftNo(map);
    }
}
