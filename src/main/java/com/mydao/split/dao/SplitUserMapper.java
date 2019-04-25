package com.mydao.split.dao;


import com.mydao.split.entity.SplitUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface SplitUserMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(SplitUser record);

    SplitUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SplitUser record);

    SplitUser getByUserName(String userName);

    List<SplitUser> findList(Map<String,Object> map);

    Integer count(Map<String,Object> map);
}