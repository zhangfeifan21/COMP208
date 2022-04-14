package com.group60.controller;

import com.group60.entity.User;
import com.group60.service.UserService;
import com.group60.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("register")
    public String register(User user, String confirmPwd){
        log.debug("email_address: {},password: {}",user.getEmail_address(),user.getPassword());
        log.debug("confirmPwd: {}",confirmPwd);
        try {
            if(user.getPassword().isEmpty()) throw new RuntimeException("please enter password");
            if(!user.getPassword().equals(confirmPwd)) throw new RuntimeException("password mismatched");
            userService.register(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return "redirect:/register";
        }
        return "redirect:/login";
    }
}
