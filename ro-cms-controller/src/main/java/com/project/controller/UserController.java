package com.project.controller;

import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/user")
    public ModelAndView userList(){
        ModelAndView view = new ModelAndView("/user/user");
        return view;
    }

    @RequestMapping(value = "/user/user1")
    @ResponseBody
    public Object userList1(){
        return userService.userList();
    }

}
