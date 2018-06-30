package com.ilidan;

import com.ilidan.cache.UserCache;
import com.ilidan.domain.User;
import com.ilidan.mapper.UserMapper;
import com.ilidan.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Hello world!
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring/applicationContext.xml"
})
public class App {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserCache userCache;

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

  /*  @Before
    public void beforeTest() {
        context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }*/

    @Test
    public void testUserCache() {
        System.out.println("第一次获取缓存中的用户数据：" + userCache.getUserCacheById(7L));
        System.out.println("清除当前用户id的缓存！");
        userCache.removeUserCacheById(7L);
        System.out.println("第二次获取缓存中的用户数据：" + userCache.getUserCacheById(7L));
        System.out.println("第三次获取缓存中的用户数据：" + userCache.getUserCacheById(7L));
    }

    @Test
    public void testFindUserById() {
        userService.findUserById(7L);
        System.out.println("==========UserService#findUserById(Long userId) second invoked!");
        userService.findUserById(7L);
        System.out.println("==========Clear the cache!");
        userService.reloadUser();
        userService.findUserById(7L);
    }

    @Test
    public void testGetUserByUsername() {
        userService.getUserByUsername("ilidan");
        System.out.println("UserService#getUserByUsername(String username) second invoked!");
        userService.getUserByUsername("ilidan");
    }

    @Test
    public void testInsertUserMethod() {

        System.out.println("isAopProxy:" + AopUtils.isAopProxy(userService));
        System.out.println("isCglibProxy:" + AopUtils.isCglibProxy(userService));
        System.out.println("isJdkDynamicProxy:" + AopUtils.isJdkDynamicProxy(userService));

        System.out.println("---------------->:" + userService);
        User user = new User();
        user.setUsername("ilidan");
        user.setPassword("123456");
        user.setMoney(342.1);

        userService.insertUser(user);
        //userMapper.insertUser(user);
    }

}
