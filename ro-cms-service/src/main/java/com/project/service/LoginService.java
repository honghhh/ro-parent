package com.project.service;

import com.project.dao.UserMapper;
import com.project.entity.User;
import com.project.rest.GetRest;
import com.project.rest.RestResponse;
import com.project.session.CmsSession;
import com.project.utils.FunctionUtils;
import com.project.utils.StaticUtils;
import com.project.utils.pwd.Encode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

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
        if (!user.getPassword().equals(Encode.md5Encode(passWord))) {
            return GetRest.getFail("密码不正确");
        }
        if (!FunctionUtils.isEquals(user.getStatus(), StaticUtils.status_yes)) {
            return GetRest.getFail("账号已被冻结");
        }
        return GetRest.getSuccess("登录成功");
    }

    /**
     * 注册
     * @param request 请求对象
     * @param userName 账号
     * @param passWord 密码
     * @param code 验证码
     * @return
     */
    public RestResponse register(HttpServletRequest request, String userName, String passWord, String code) {
        if (StringUtils.isBlank(userName)) {
            return GetRest.getFail("请输入账号");
        }
        if (StringUtils.isBlank(passWord)) {
            return GetRest.getFail("请输入密码");
        }
        if (StringUtils.isBlank(code)) {
            return GetRest.getFail("请输入验证码");
        }
        User user = userMapper.queryByLogin(userName);
        if (user != null) {
            return GetRest.getFail("该账号已存在");
        }
        String vcode = CmsSession.getValidCode(request).toLowerCase();
        if (!vcode.equals(code.toLowerCase())) {
            return GetRest.getFail("验证码不正确");
        }
        user = new User();
        user.setLogin(userName);
        user.setPassword(Encode.md5Encode(passWord));
        int i = userMapper.insertSelective(user);
        if (i < 1) {
            return GetRest.getFail("注册失败");
        }
        return GetRest.getSuccess("注册成功");
    }
}
