package com.project.service;

import com.project.dao.UserMapper;
import com.project.entity.User;
import com.project.entity.UserExample;
import com.project.log.SystemLog;
import com.project.rest.GetRest;
import com.project.rest.RestResponse;
import com.project.utils.activemq.ConsumerService;
import com.project.utils.activemq.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import java.util.List;

@Service
@EnableCaching
public class TestService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private ProducerService producerService;
    @Autowired
    private ConsumerService consumerService;

    @Cacheable(value = "myCache")
    public RestResponse queryUserList() {
        return GetRest.getSuccess("", userMapper.selectByExample(new UserExample()));
    }

    @SystemLog(module = "登录模块", methods = "登录")
    public String login() {
        return "";
    }

    public List<User> queryUserList2() {
        List<User> list = userMapper.selectByExample(new UserExample());
        return list;
    }

    public void test7(){
        Destination destination = jmsTemplate.getDefaultDestination();
        producerService.sendMessage(destination, "123123");
        producerService.sendMessage("123123");
    }

    public void test8(){
        Destination destination = jmsTemplate.getDefaultDestination();
        consumerService.receive(destination);
    }
}