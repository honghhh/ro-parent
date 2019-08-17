package com.project.controller;

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
        ModelAndView view = new ModelAndView(MappingUtil.login);
        return view;
    }
}
