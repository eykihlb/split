package com.mydao.split.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Mapper
@Component
public interface DataTransactionMapper {

    int selectTotalTriffic(Map<String,Object> map);
}