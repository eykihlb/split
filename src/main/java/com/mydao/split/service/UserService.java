package com.mydao.split.service;

import com.mydao.split.entity.User;
import org.springframework.stereotype.Component;

/**
 * @program: redis-demo
 * @description:
 * @author: Eyki
 * @create: 2019-03-20 18:14
 **/
@Component
public interface UserService {

    int deleteByPrimaryKey(Long id);

    User insertSelective(User record);

    User selectByPrimaryKey(Long id);

    User updateByPrimaryKeySelective(User record);
}
