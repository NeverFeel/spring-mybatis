package com.ilidan.mapper;

import com.ilidan.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ilidan_Y
 * @Package com.ilidan.mapper
 * @Description:
 * @date 2018/6/26
 * @Modified by:
 */
public interface UserMapper {

    void insertUser(User user);

    User getUserById(@Param("userId") Long userId);

    User getUserByUsername(String username);

    List<User> findUserList();

}
