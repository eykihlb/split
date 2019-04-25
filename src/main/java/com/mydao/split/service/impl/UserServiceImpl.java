package com.mydao.split.service.impl;

import com.mydao.split.dao.SplitUserMapper;
import com.mydao.split.entity.SplitUser;
import com.mydao.split.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: redis-demo
 * @description:
 * @author: Eyki
 * @create: 2019-03-20 18:14
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SplitUserMapper splitUserMapper;

    @Cacheable(value="user",key="'user'+#userName.toString()")
    @Override
    public SplitUser getByUserName(String userName) {
        SplitUser user = splitUserMapper.getByUserName(userName);
        return user;
    }

    @Override
    public Map<String,Object> findList(Map<String, Object> map) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("list",splitUserMapper.findList(map));
        resultMap.put("count",splitUserMapper.count(map));
        return resultMap;
    }

    @CacheEvict(value="user", key="'user'+#id.toString()")
    @Override
    public int deleteByPrimaryKey(String id) {
        return splitUserMapper.deleteByPrimaryKey(id);
    }

    @CachePut(value = "user",key = "'user'+#record.id.toString()",unless = "#record eq null")
    @Override
    public SplitUser insertSelective(SplitUser record) {
        splitUserMapper.insertSelective(record);
        return record;
    }

    @Cacheable(value="user",key="'user'+#id.toString()")
    @Override
    public SplitUser selectByPrimaryKey(String id) {
        System.out.println("走的数据库");
        return splitUserMapper.selectByPrimaryKey(id);
    }

    @CachePut(value = "user",key = "'user'+#record.id.toString()",unless = "#record eq null")
    @Override
    public SplitUser updateByPrimaryKeySelective(SplitUser record) {
        splitUserMapper.updateByPrimaryKeySelective(record);
        return record;
    }
}
