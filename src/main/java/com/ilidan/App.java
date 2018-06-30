package com.ilidan;

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

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

  /*  @Before
    public void beforeTest() {
        context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }*/

    @Test
    public void testInsertUserMethod() {

        System.out.println("---------------->:"+userService);
        User user = new User();
        user.setUsername("ilidan");
        user.setPassword("123456");
        user.setMoney(342.1);

        userService.insert(user);
        //userMapper.insertUser(user);

    }

}
