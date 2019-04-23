package com.mydao.split.dao;


import com.mydao.split.entity.SplitUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface SplitUserMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(SplitUser record);

    SplitUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SplitUser record);

    SplitUser getByUserName(String userName);
}