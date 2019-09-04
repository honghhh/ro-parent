package com.project.service;

import com.github.pagehelper.PageHelper;
import com.project.dao.RoleMapper;
import com.project.dao.UserMapper;
import com.project.entity.Role;
import com.project.entity.User;
import com.project.rest.GetRest;
import com.project.rest.RestResponse;
import com.project.utils.pwd.Encode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 管理员业务
 * @author: huangh
 * @since 2019-09-02 17:19
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 修改密码
     * @param userId 用户id
     * @param oldPwd 旧密码
     * @param newPwdOne 新密码
     * @param newPwdTwo 确认密码
     * @return com.project.rest.RestResponse
     */
    public RestResponse updatePassword(Integer userId, String oldPwd, String newPwdOne, String newPwdTwo) {
        if (StringUtils.isBlank(oldPwd)) {
            return GetRest.getFail("请输入旧密码");
        }
        if (StringUtils.isBlank(newPwdOne)) {
            return GetRest.getFail("请输入新密码");
        }
        if (StringUtils.isBlank(newPwdTwo)) {
            return GetRest.getFail("请输入确认密码");
        }
        if (!StringUtils.equals(newPwdOne, newPwdTwo)) {
            return GetRest.getFail("两次密码不一致");
        }
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return GetRest.getFail("用户不存在");
        }
        if (!StringUtils.equals(user.getPassword(), Encode.md5Encode(oldPwd))) {
            return GetRest.getFail("原密码错误");
        }
        user.setPassword(Encode.md5Encode(newPwdOne));
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i < 1) {
            return GetRest.getFail("修改失败");
        }
        return GetRest.getSuccess("修改成功");
    }

    /**
     * 获取管理员列表
     * @param user 搜索对象
     * @return java.util.List<com.project.entity.User>
     */
    public List<User> showUserList(User user) {
        if (user.isIspage()) {
            PageHelper.startPage(user.getPage(), user.getRows());
        }
        List<User> list = userMapper.queryList(user);
        for (User u : list) {
            // 角色名称
            Role role = roleMapper.selectByPrimaryKey(u.getRoleid());
            u.setRoleName(role.getName());
        }
        return list;
    }
}
