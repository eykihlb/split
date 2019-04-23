package com.mydao.split.service.impl;

import com.mydao.split.dao.UserMapper;
import com.mydao.split.entity.User;
import com.mydao.split.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @program: redis-demo
 * @description:
 * @author: Eyki
 * @create: 2019-03-20 18:14
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @CacheEvict(value="user", key="'user'+#id.toString()")
    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @CachePut(value = "user",key = "'user'+#record.id.toString()",unless = "#record eq null")
    @Override
    public User insertSelective(User record) {
        userMapper.insertSelective(record);
        return record;
    }

    @Cacheable(value="user",key="'user'+#id.toString()")
    @Override
    public User selectByPrimaryKey(Long id) {
        System.out.println("走的数据库");
        return userMapper.selectByPrimaryKey(id);
    }

    @CachePut(value = "user",key = "'user'+#record.id.toString()",unless = "#record eq null")
    @Override
    public User updateByPrimaryKeySelective(User record) {
        userMapper.updateByPrimaryKeySelective(record);
        return record;
    }
}
