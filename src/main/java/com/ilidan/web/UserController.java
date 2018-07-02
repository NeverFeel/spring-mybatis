package com.ilidan.web;

import com.ilidan.domain.User;
import com.ilidan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ilidan_Y
 * @Package com.ilidan.web
 * @Description:
 * @date 2018/7/1
 * @Modified by:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @RequestMapping("/register")
    public String register() {
        System.out.println("UserController#register() invoked!");
        return "user/register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView createUser(User user) {
        ModelAndView modelAndView = new ModelAndView();
        userService.insertUser(user);
        modelAndView.setViewName("user/createSuccess");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
