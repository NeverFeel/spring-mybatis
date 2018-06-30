package com.ilidan.cache;

import com.ilidan.domain.User;
import com.ilidan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author ilidan_Y
 * @Package com.ilidan.cache
 * @Description:
 * @date 2018/6/30
 * @Modified by:
 */
@Component
public class UserCache {

    private CacheManager cacheManager;

    private UserService userService;

    private Cache userCache;

    @PostConstruct
    public void initUserCache() {
        List<User> userList = userService.findUserList();
        userList.forEach(user -> userCache.put(user.getId(), user));
        System.out.println("===========初始化用户数据:" + userList.size() + "条=============");
    }

    public User getUserCacheById(Long userId) {
        User user = userCache.get(userId, User.class);
        if (user == null) {
            System.out.println("缓存中不存在用户Id为：" + userId + "的数据");
            user = userService.findUserById(userId);
            userCache.put(user.getId(), user);
        }
        return user;
    }

    public void removeUserCacheById(Long userId) {
        userCache.evict(userId);
    }

    public void removeUserAllCache() {
        userCache.clear();
    }

    @Autowired
    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
        this.userCache = cacheManager.getCache("users");
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
