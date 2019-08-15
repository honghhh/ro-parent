package com.project.service;

import com.project.dao.UserMapper;
import com.project.entity.User;
import com.project.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> userList(){
        return userMapper.selectByExample(new UserExample());
    }
}
