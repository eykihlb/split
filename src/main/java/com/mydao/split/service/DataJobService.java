package com.mydao.split.service;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface DataJobService {

    int selectTotalTriffic(Map<String,Object> map);
}
