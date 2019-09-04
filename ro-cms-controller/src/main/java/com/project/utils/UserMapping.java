package com.project.utils;

/**
 * @description 管理员地址映射工具类
 * @author: huangh
 * @since 2019-09-02 17:15
 */
public class UserMapping {

    /** 页面 - 修改密码 */
    public static final String SHOW_UPDATE_PASSWORD = "/user/showUpdatePassword";

    /** 操作 - 修改密码 */
    public static final String UPDATE_PASSWORD = "/user/updatePassword";

    /** 页面 - 管理员列表 */
    public static final String SHOW_USER_LIST = "/user/showUserList";

    /** 页面 - 新增/编辑管理员 */
    public static final String SHOW_USER_EDIT = "/user/showUserEdit";

    /** 操作 - 新增/编辑管理员 */
    public static final String EDIT_USER = "/user/editUser";

    /** 操作 - 删除管理员 */
    public static final String DELETE_USER = "/user/deleteUser";

    /** 操作 - 启用/禁用管理员 */
    public static final String UPDATE_USER_STATUS = "/user/updateUserStatus";
}
