package com.ilidan.mapper;

import com.ilidan.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author ilidan_Y
 * @Package com.ilidan.mapper
 * @Description:
 * @date 2018/6/26
 * @Modified by:
 */
public interface UserMapper {

    void insertUser(User user);

}
