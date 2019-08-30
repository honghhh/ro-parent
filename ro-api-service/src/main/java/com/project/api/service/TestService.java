package com.project.api.service;

import com.project.api.log.SystemLog;
import com.project.dao.UserMapper;
import com.project.entity.User;
import com.project.entity.UserExample;
import com.project.rest.GetRest;
import com.project.rest.RestResponse;
import com.project.utils.activemq.ConsumerService;
import com.project.utils.activemq.ProducerService;
import com.project.utils.pwd.Encode;
import com.project.utils.redis.RedisUtil;
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
    private RedisUtil redisUtil;
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

    public void test7(){
        Destination destination = jmsTemplate.getDefaultDestination();
        producerService.sendMessage(destination, "api");
        // producerService.sendMessage("123123");
    }

    public void test8(){
        Destination destination = jmsTemplate.getDefaultDestination();
        consumerService.receive(destination);
    }

    public RestResponse test9(){
        List<User> list = userMapper.selectByExample(new UserExample());
        return GetRest.getSuccess("", list);
    }

    public RestResponse test10(Integer id, String login, String password){
        int i = 0;
        if (id == null) {
            User user = new User();
            user.setLogin(login);
            user.setPassword(Encode.md5Encode(password));
            i = userMapper.insertSelective(user);
            if (i < 1) {
                return GetRest.getSuccess("新增失败");
            }else{
                return GetRest.getFail("新增成功");
            }
        }else {
            User user = userMapper.selectByPrimaryKey(id);
            user.setLogin(login);
            if (!user.getPassword().equals(password)) {
                user.setPassword(Encode.md5Encode(password));
            }
            i = userMapper.updateByPrimaryKeySelective(user);
            if (i < 1) {
                return GetRest.getSuccess("编辑失败");
            }else {
                return GetRest.getFail("编辑成功");
            }
        }
    }

    public RestResponse test11(Integer id){
        int i = userMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            return GetRest.getFail("删除失败");
        }
        return GetRest.getSuccess("删除成功");
    }
}
