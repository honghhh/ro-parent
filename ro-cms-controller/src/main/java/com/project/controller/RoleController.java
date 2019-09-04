package com.project.controller;

import com.project.entity.Menu;
import com.project.entity.Role;
import com.project.rest.RestResponse;
import com.project.service.RoleService;
import com.project.utils.RoleMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @description 角色Handle
 * @author: huangh
 * @since 2019-09-03 14:06
 */
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 角色列表页面
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = RoleMapping.SHOW_ROLE_LIST)
    public ModelAndView showRoleList() {
        ModelAndView view = new ModelAndView(RoleMapping.SHOW_ROLE_LIST);
        List<Role> list = roleService.queryRoleList();
        view.addObject("list", list);
        return view;
    }

    /**
     * 新增/编辑角色页面
     * @param id 角色id
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = RoleMapping.SHOW_ROLE_EDIT)
    public ModelAndView showRoleEdit(Integer id) {
        ModelAndView view = new ModelAndView(RoleMapping.SHOW_ROLE_EDIT);
        Role role = roleService.queryRole(id);
        List<Menu> list = roleService.queryMenuList(role);
        view.addObject("role", role);
        view.addObject("list", list);
        return view;
    }

    /**
     * 新增/编辑角色信息
     * @param role 角色信息
     * @return com.project.rest.RestResponse
     */
    @RequestMapping(value = RoleMapping.EDIT_ROLE)
    @ResponseBody
    public RestResponse editRole(Role role) {
        RestResponse result = roleService.editRole(role);
        return result;
    }

    /**
     * 启用/禁用角色
     * @param id 角色id
     * @param status 状态
     * @return com.project.rest.RestResponse
     */
    @RequestMapping(value = RoleMapping.UPDATE_ROLE_STATUS)
    @ResponseBody
    public RestResponse updateRoleStatus(Integer id, Integer status) {
        RestResponse result = roleService.updateRoleStatus(id, status);
        return result;
    }

    /**
     * 删除角色
     * @param id 角色id
     * @return com.project.rest.RestResponse
     */
    @RequestMapping(value = RoleMapping.DELETE_ROLE)
    @ResponseBody
    public RestResponse deleteRole(Integer id) {
        RestResponse result = roleService.deleteRole(id);
        return result;
    }
}
