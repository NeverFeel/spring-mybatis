package com.ilidan.service.impl;

import com.ilidan.domain.User;
import com.ilidan.mapper.UserMapper;
import com.ilidan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ilidan_Y
 * @Package com.ilidan.service
 * @Description:
 * @date 2018/6/26
 * @Modified by:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public void insert(User user){
        System.out.println("UserServiceImpl#insert() invoked!");
        userMapper.insertUser(user);
    }

}
