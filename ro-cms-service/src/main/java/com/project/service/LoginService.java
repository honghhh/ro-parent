package com.project.service;

import com.project.dao.MenuMapper;
import com.project.dao.RoleMapper;
import com.project.dao.UserMapper;
import com.project.dto.cms.LoginDTO;
import com.project.entity.Menu;
import com.project.entity.MenuExample;
import com.project.entity.Role;
import com.project.entity.User;
import com.project.rest.GetRest;
import com.project.rest.RestResponse;
import com.project.session.CmsSession;
import com.project.utils.FunctionUtils;
import com.project.utils.StaticUtils;
import com.project.utils.cookies.CookiesUtil;
import com.project.utils.jwt.JwtUtil;
import com.project.utils.pwd.Encode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description 平台Handle
 * @author: huangh
 * @since 2019-09-02 15:21
 */
@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 登录
     * @param request 请求对象
     * @param response 返回对象
     * @param userName 账号
     * @param passWord 密码
     * @return com.project.rest.RestResponse
     */
    public RestResponse login(HttpServletRequest request, HttpServletResponse response, String userName, String passWord){
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
        // 查询菜单
        Role role = roleMapper.selectByPrimaryKey(user.getRoleid());
        if (role == null) {
            return GetRest.getFail("角色不存在，请联系后台人员分配角色");
        }
        // 根据角色所有的菜单id
        List<Integer> list = FunctionUtils.getIntegerList(role.getMenuids().split(","));
        if (list == null || list.size() < 1) {
            return GetRest.getFail("当前角色没有菜单权限");
        }
        MenuExample example = new MenuExample();
        example.createCriteria().andIdIn(list).andStatusEqualTo(StaticUtils.status_yes);
        example.setOrderByClause("sort asc");
        List<Menu> menus = menuMapper.selectByExample(example);
        // 获取菜单地址集合
        List<String> menuUrls = new ArrayList<>();
        for (Menu m : menus) {
            menuUrls.add(m.getUrl());
        }
        // 保存登录信息对象
        LoginDTO loginDto = new LoginDTO();
        loginDto.setUserid(user.getId());
        loginDto.setLogin(user.getLogin());
        loginDto.setPassword(user.getPassword());
        loginDto.setNickname(user.getNickname());
        loginDto.setRolename(role.getName());
        // 保存到session
        CmsSession.setUser(request, loginDto);
        CmsSession.setUserId(request, user.getId());
        CmsSession.setRoleId(request, user.getRoleid());
        CmsSession.setMenuList(request, menus);
        CmsSession.setMenuUrlList(request, menuUrls);
        // 生成jwt 设置30分钟有效期
        String token = JwtUtil.createJWT(TimeUnit.MINUTES.toMillis(30), loginDto);
        // 写入token到cookie 页面请求自动携带cookie
        CookiesUtil.setCookie(response, "token", token);
        return GetRest.getSuccess("登录成功");
    }

    /**
     * 注册
     * @param request 请求对象
     * @param userName 账号
     * @param passWord 密码
     * @param code 验证码
     * @return com.project.rest.RestResponse
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
