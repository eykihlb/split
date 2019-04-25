package com.mydao.split.service;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface DataTransactionService {

    int selectTotalTriffic(Map<String,Object> map);
}
