package com.mydao.split.dao;

import com.mydao.split.entity.DataJob;
import com.mydao.split.entity.DataJobKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Mapper
public interface DataJobMapper {

    int deleteByPrimaryKey(DataJobKey key);

    int insertSelective(DataJob record);

    DataJob selectByPrimaryKey(DataJobKey key);

    int updateByPrimaryKeySelective(DataJob record);

    int selectTotalTriffic(Map<String,Object> map);
}