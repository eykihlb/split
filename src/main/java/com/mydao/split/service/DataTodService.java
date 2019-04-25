package com.mydao.split.service;

import com.mydao.split.entity.DataTod;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface DataTodService {

    List<DataTod> selectBySiteNoAndShiftNo(Map<String,Object> map);
}
