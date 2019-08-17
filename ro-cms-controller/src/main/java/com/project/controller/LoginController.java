package com.project.controller;

import com.project.entity.User;
import com.project.exception.ThrowPageException;
import com.project.service.LoginService;
import com.project.utils.MappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = MappingUtil.login)
    public ModelAndView login(){
        loginService.userList();
        ModelAndView view = new ModelAndView(MappingUtil.login);
        try {
            User user = null;
            System.out.println(user.getActivated());
        } catch (Exception e) {
            throw new ThrowPageException("好的");
        }
        return view;
    }
}
