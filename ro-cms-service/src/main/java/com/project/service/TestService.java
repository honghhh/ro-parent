package com.project.service;

import com.project.dao.UserMapper;
import com.project.entity.User;
import com.project.entity.UserExample;
import com.project.log.SystemLog;
import com.project.rest.GetRest;
import com.project.rest.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
public class TestService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "myCache")
    public RestResponse queryUserList() {
        return GetRest.getSuccess("", userMapper.selectByExample(new UserExample()));
    }

    @SystemLog(module = "登录模块", methods = "登录")
    public String login() {
        return "";
    }

    public Object queryUserList2() {
        Object object = userMapper.selectByExample(new UserExample());
        return object;
    }
}