package com.project.session;

import com.project.dto.cms.LoginDTO;
import com.project.entity.Menu;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description CmsSession
 * @author: huangh
 * @since 2019-09-02 15:44
 */
public class CmsSession {

    /** 验证码 */
    public static final String VALID_CODE = "validCode";

    /** 角色id */
    public static final String ROLE_ID = "roleId";

    /** 用户id */
    public static final String USER_ID = "userId";

    /** 操作员 */
    public static final String USER = "user";

    /** 菜单 */
    public static final String MENU_LIST = "menusList";

    /** 菜单路径 */
    public static final String MENU_URLS = "menuUrls";

    /**
     * 验证码对象设置session
     */
    public static void setValidCode(HttpServletRequest request, String validCode) {
        request.getSession().removeAttribute(VALID_CODE);
        request.getSession().setAttribute(VALID_CODE, validCode);
    }

    /**
     * 验证码对象获取session
     */
    public static String getValidCode(HttpServletRequest request) {
        return (String) request.getSession().getAttribute(VALID_CODE);
    }

    /**
     * 角色id设置session
     */
    public static void setRoleId(HttpServletRequest request, Integer roleId) {
        request.getSession().removeAttribute(ROLE_ID);
        request.getSession().setAttribute(ROLE_ID, roleId);
    }

    /**
     * 角色id获取session
     */
    public static Integer getRoleId(HttpServletRequest request) {
        return (Integer) request.getSession().getAttribute(ROLE_ID);
    }

    /**
     * 用户id设置session
     */
    public static void setUserId(HttpServletRequest request, Integer userId) {
        request.getSession().removeAttribute(USER_ID);
        request.getSession().setAttribute(USER_ID, userId);
    }

    /**
     * 用户id获取session
     */
    public static Integer getUserId(HttpServletRequest request) {
        return (Integer) request.getSession().getAttribute(USER_ID);
    }

    /**
     * 用户设置session
     */
    public static void setUser(HttpServletRequest request, LoginDTO loginDto) {
        request.getSession().removeAttribute(USER);
        request.getSession().setAttribute(USER, loginDto);
    }

    /**
     * 用户获取session
     */
    public static LoginDTO getUser(HttpServletRequest request) {
        return (LoginDTO) request.getSession().getAttribute(USER);
    }

    /**
     * 菜单设置session
     */
    public static void setMenuList(HttpServletRequest request, List<Menu> menuList) {
        request.getSession().removeAttribute(MENU_LIST);
        request.getSession().setAttribute(MENU_LIST, menuList);
    }

    /**
     * 菜单获取session
     */
    @SuppressWarnings("unchecked")
    public static List<Menu> getMenuList(HttpServletRequest request) {
        return (List<Menu>) request.getSession().getAttribute(MENU_LIST);
    }

    /**
     * 菜单路径名设置session
     */
    public static void setMenuUrlList(HttpServletRequest request, List<String> menuUrls) {
        request.getSession().removeAttribute(MENU_URLS);
        request.getSession().setAttribute(MENU_URLS, menuUrls);
    }

    /**
     * 菜单路径名获取session
     */
    @SuppressWarnings("unchecked")
    public static List<String> getMenuUrlList(HttpServletRequest request) {
        return (List<String>) request.getSession().getAttribute(MENU_URLS);
    }

    /**
     * 退出
     */
    public static void exit(HttpServletRequest request) {
        request.getSession().removeAttribute(MENU_LIST);
        request.getSession().removeAttribute(USER_ID);
        request.getSession().removeAttribute(ROLE_ID);
        request.getSession().removeAttribute(USER);
        request.getSession().removeAttribute(MENU_URLS);
    }
}
