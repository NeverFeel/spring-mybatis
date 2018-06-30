package com.ilidan.service;

import com.ilidan.domain.User;

import java.util.List;

/**
 * @author ilidan_Y
 * @Package com.ilidan.service
 * @Description:
 * @date 2018/6/27
 * @Modified by:
 */
public interface UserService {

    void insertUser(User user);

    User getUserByUsername(String username);

    User findUserById(Long userId);

    void reloadUser();

    List<User> findUserList();

}
