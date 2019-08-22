package com.project.api.controller;

import com.project.api.service.LoginService;
import com.project.api.utils.MappingUtil;
import com.project.rest.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     * @param userName 账号
     * @param passWord 密码
     * @return
     */
    @RequestMapping(value = MappingUtil.login)
    @ResponseBody
    public RestResponse login(HttpServletRequest request, HttpServletResponse response, String userName, String passWord) {
        RestResponse result = loginService.login(request, response, userName, passWord);
        return result;
    }
}
