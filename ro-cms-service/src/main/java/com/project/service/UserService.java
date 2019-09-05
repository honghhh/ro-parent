package com.project.service;

import com.github.pagehelper.PageHelper;
import com.project.dao.RoleMapper;
import com.project.dao.UserMapper;
import com.project.entity.Role;
import com.project.entity.RoleExample;
import com.project.entity.User;
import com.project.exception.ThrowJsonException;
import com.project.rest.GetRest;
import com.project.rest.RestResponse;
import com.project.utils.FunctionUtils;
import com.project.utils.StaticUtils;
import com.project.utils.pwd.Encode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
     * @param userId 管理员id
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
     * @param userObj 搜索对象
     * @return java.util.List<com.project.entity.User>
     */
    public List<User> showUserList(User userObj) {
        if (userObj.isIspage()) {
            PageHelper.startPage(userObj.getPage(), userObj.getRows());
        }
        List<User> list = userMapper.queryList(userObj);
        for (User u : list) {
            // 角色名称
            Role role = roleMapper.selectByPrimaryKey(u.getRoleid());
            u.setRoleName(role.getName());
        }
        return list;
    }

    /**
     * 新增/编辑管理员
     * @param userObj 管理员信息
     * @param imgUrl 图片信息
     * @return com.project.rest.RestResponse
     */
    public RestResponse editUser(User userObj, HttpServletRequest request, MultipartFile imgUrl) {
        if (userObj.getLogin() == null) {
            return GetRest.getFail("请输入账号");
        }
        if (StringUtils.isBlank(userObj.getNickname())) {
            return GetRest.getFail("请输入管理员昵称");
        }
        if (userObj.getRoleid() == null) {
            return GetRest.getFail("请选择管理员角色");
        }
        if (userObj.getId() == null) {
            User user = userMapper.queryByLogin(userObj.getLogin());
            if (user != null) {
                return GetRest.getFail("账号已存在");
            }
        }
        if (userObj.getId() == null && imgUrl == null) {
            return GetRest.getFail("请上传管理员头像");
        }
        if (imgUrl != null) {
            // 上传头像
            String headurl = FunctionUtils.uploadOneImages(request, imgUrl);
            if (StringUtils.isBlank(headurl)) {
                throw new ThrowJsonException("上传失败");
            }
            userObj.setHeadurl(headurl);
        }
        int i = 0;
        if (userObj.getId() == null) {
            userObj.setPassword(Encode.md5Encode(StaticUtils.DEFAULT_PASSWORD));
            i = userMapper.insertSelective(userObj);
        } else {
            i = userMapper.updateByPrimaryKeySelective(userObj);
        }
        if (i < 1) {
            return GetRest.getFail("保存失败");
        }
        return GetRest.getSuccess("保存成功");
    }

    /**
     * 删除管理员
     * @param id 管理员id
     * @return com.project.rest.RestResponse
     */
    public RestResponse deleteUser(Integer id) {
        int i = userMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            return GetRest.getFail("删除失败");
        }
        return GetRest.getSuccess("删除成功");
    }

    /**
     * 启用/禁用管理员
     * @param id 管理员id
     * @param status 状态
     * @return com.project.rest.RestResponse
     */
    public RestResponse updateUserStatus(Integer id, Integer status) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            return GetRest.getFail("管理员不存在");
        }
        user.setStatus(status);
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i < 1) {
            return GetRest.getFail("操作失败");
        }
        return GetRest.getSuccess("操作成功");
    }

    /**
     * 获取管理员信息
     * @param id 管理员id
     * @return com.project.entity.User
     */
    public User queryUser(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取角色列表
     * @return java.util.List<com.project.entity.Role>
     */
    public List<Role> queryRoleList() {
        return roleMapper.selectByExample(new RoleExample());
    }
}
