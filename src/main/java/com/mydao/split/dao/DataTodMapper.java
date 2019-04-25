package com.mydao.split.dao;


import com.mydao.split.entity.DataTod;
import com.mydao.split.entity.DataTodKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface DataTodMapper {

    int deleteByPrimaryKey(DataTodKey key);

    int insertSelective(DataTod record);

    DataTod selectByPrimaryKey(DataTodKey key);

    int updateByPrimaryKeySelective(DataTod record);

    List<DataTod> selectBySiteNoAndShiftNo(Map<String,Object> map);
}