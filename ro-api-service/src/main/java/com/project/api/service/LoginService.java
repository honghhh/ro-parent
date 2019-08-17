package com.project.api.service;

import com.project.dao.UserMapper;
import com.project.entity.User;
import com.project.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 一个缓存名为userList 建为传入的id的缓存
     */
    @Cacheable(value="myCache", key = "#user.username")
    public List<User> userList(User user){
        return userMapper.selectByExample(new UserExample());
    }
}
