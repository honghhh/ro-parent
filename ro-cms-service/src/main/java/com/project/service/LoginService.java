package com.project.service;

import com.project.dao.UserMapper;
import com.project.entity.User;
import com.project.rest.GetRest;
import com.project.rest.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * @param userName 账号
     * @param passWord 密码
     * @return
     */
    public RestResponse login(String userName, String passWord){
        if (StringUtils.isBlank(userName)) {
            return GetRest.getFail("请输入账号");
        }
        if (StringUtils.isBlank(passWord)) {
            return GetRest.getFail("请输入密码");
        }
        User user = userMapper.queryByLogin(userName);
        if (user == null) {
            return GetRest.getFail("账号不存在");
        }
        if (!user.getPassword().equals(passWord)) {
            return GetRest.getFail("密码不正确");
        }
        return GetRest.getSuccess("登录成功");
    }
}
