package com.mydao.split.service;

import com.mydao.split.entity.SplitUser;
import org.springframework.stereotype.Component;

/**
 * @program: redis-demo
 * @description:
 * @author: Eyki
 * @create: 2019-03-20 18:14
 **/
@Component
public interface UserService {

    int deleteByPrimaryKey(String id);

    SplitUser insertSelective(SplitUser record);

    SplitUser selectByPrimaryKey(String id);

    SplitUser updateByPrimaryKeySelective(SplitUser record);

    SplitUser getByUserName(String userName);
}
