package com.project.api.service;

import com.project.api.log.SystemLog;
import com.project.dao.UserMapper;
import com.project.entity.UserExample;
import com.project.rest.GetRest;
import com.project.rest.RestResponse;
import com.project.utils.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

@Service
@EnableCaching
public class TestService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Cacheable(value = "myCache")
    public RestResponse queryUserList() {
        return GetRest.getSuccess("", userMapper.selectByExample(new UserExample()));
    }

    @SystemLog(module = "登录模块", methods = "登录")
    public String login() {
        return "";
    }

    public String test6(){
        // 设置redis
        Boolean flag = redisUtil.set("1", "123123", new Long(20));
        if (flag) {
            System.out.println(true);
        }
        // 获取redis
        String get = (String) redisUtil.get("1");
        System.out.println(get);
        // 判断redis是否存在
        flag = redisUtil.exists("1");
        if (flag) {
            System.out.println(true);
        }
        // 删除redis
        redisUtil.remove("1");
        return "";
    }
}
