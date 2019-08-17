package com.project.api.controller;

import com.project.api.service.LoginService;
import com.project.api.utils.MappingUtil;
import com.project.rest.GetRest;
import com.project.rest.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = MappingUtil.login)
    @ResponseBody
    public RestResponse login() {
        return GetRest.getSuccess("");
    }
}
