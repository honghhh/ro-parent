package com.project.controller;

import com.github.pagehelper.PageInfo;
import com.project.entity.User;
import com.project.rest.RestResponse;
import com.project.service.UserService;
import com.project.session.CmsSession;
import com.project.utils.UserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description 管理员Handle
 * @author: huangh
 * @since 2019-09-02 17:19
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 修改密码页面
     * @param request 请求对象
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = UserMapping.SHOW_UPDATE_PASSWORD)
    public ModelAndView showUpdatePassword(HttpServletRequest request) {
        Integer userId = CmsSession.getUserId(request);
        ModelAndView view = new ModelAndView(UserMapping.SHOW_UPDATE_PASSWORD);
        view.addObject("userId", userId);
        return view;
    }

    /**
     * 修改密码
     * @param userId 用户id
     * @param oldPwd 旧密码
     * @param newPwdOne 新密码
     * @param newPwdTwo 确认密码
     * @return com.project.rest.RestResponse
     */
    @RequestMapping(value = UserMapping.UPDATE_PASSWORD)
    @ResponseBody
    public RestResponse updatePassword(Integer userId, String oldPwd, String newPwdOne, String newPwdTwo) {
        RestResponse result = userService.updatePassword(userId, oldPwd, newPwdOne, newPwdTwo);
        return result;
    }

    /**
     * 管理员列表页面
     * @param user 搜索对象
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = UserMapping.SHOW_USER_LIST)
    public ModelAndView showUserList(User user) {
        ModelAndView view = new ModelAndView(UserMapping.SHOW_USER_LIST);
        List<User> list = userService.showUserList(user);
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        view.addObject("pageInfo", pageInfo);
        view.addObject("user", user);
        return view;
    }
}
