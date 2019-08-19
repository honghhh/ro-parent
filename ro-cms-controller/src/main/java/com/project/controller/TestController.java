package com.project.controller;

import com.project.entity.User;
import com.project.exception.ThrowJsonException;
import com.project.exception.ThrowPageException;
import com.project.rest.GetRest;
import com.project.rest.RestResponse;
import com.project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * 测试spring缓存
     */
    @RequestMapping(value = "/test1")
    @ResponseBody
    public RestResponse test1() {
        RestResponse result = testService.queryUserList();
        return result;
    }

    /**
     * 测试json全局异常
     */
    @RequestMapping(value = "/test2")
    @ResponseBody
    public RestResponse test2(){
        try {
            User user = null;
            System.out.println(user.getPassword());
        } catch (Exception e) {
            throw new ThrowJsonException("json全局异常处理成功");
        }
        return GetRest.getSuccess("");
    }

    /**
     * 测试json全局异常
     */
    @RequestMapping(value = "/test3")
    public ModelAndView test3(){
        ModelAndView view = new ModelAndView("/api/test3");
        try {
            User user = null;
            System.out.println(user.getPassword());
        } catch (Exception e) {
            throw new ThrowPageException("page全局异常处理成功");
        }
        return view;
    }
}
