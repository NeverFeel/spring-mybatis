package com.ilidan.service.impl;

import com.ilidan.domain.User;
import com.ilidan.mapper.UserMapper;
import com.ilidan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void insertUser(User user) {
        System.out.println("UserServiceImpl#insert() invoked!");
        userMapper.insertUser(user);
    }

    @Cacheable(cacheNames = "users")
    public User getUserByUsername(String username) {
        System.out.println(username + " get user from db...");
        return userMapper.getUserByUsername(username);
    }

    /**
     * 根据userId查找User信息
     *
     * @param userId 用户id
     * @return User
     */
    @Override
    public User findUserById(Long userId) {
        System.out.println("==========从数据库读取数据===========");
        return userMapper.getUserById(userId);
    }

    /**
     * 刷新User缓存
     */
    @Override
    public void reloadUser() {
        System.out.println("User cache reload success");
    }

    @Override
    public List<User> findUserList() {
        return userMapper.findUserList();
    }

}
