package com.project.api.controller;

import com.project.api.service.LoginService;
import com.project.api.utils.MappingUtils;
import com.project.rest.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description 登录Handle
 * @author: huangh
 * @since 2019-09-02 15:03
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     * @param request 请求对象
     * @param response 返回对象
     * @param userName 账号
     * @param passWord 密码
     * @return com.project.rest.RestResponse
     */
    @RequestMapping(value = MappingUtils.LOGIN)
    @ResponseBody
    public RestResponse login(HttpServletRequest request, HttpServletResponse response, String userName, String passWord) {
        RestResponse result = loginService.login(request, response, userName, passWord);
        return result;
    }
}
