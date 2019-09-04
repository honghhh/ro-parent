package com.project.service;

import com.project.dao.MenuMapper;
import com.project.dao.RoleMapper;
import com.project.entity.Menu;
import com.project.entity.MenuExample;
import com.project.entity.Role;
import com.project.entity.RoleExample;
import com.project.rest.GetRest;
import com.project.rest.RestResponse;
import com.project.utils.StaticUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description 角色业务
 * @author: huangh
 * @since 2019-09-03 14:06
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 查询角色列表
     * @return java.util.List<com.project.entity.Role>
     */
    public List<Role> queryRoleList() {
        return roleMapper.selectByExample(new RoleExample());
    }

    /**
     * 编辑角色信息
     * @param role 角色信息
     * @return com.project.rest.RestResponse
     */
    public RestResponse editRole(Role role) {
        if (StringUtils.isBlank(role.getName())) {
            return GetRest.getFail("请填写角色名称");
        }
        if (StringUtils.isBlank(role.getMenuids())) {
            return GetRest.getFail("请选择菜单");
        }
        // 去重复
        Set<String> menuList = new HashSet<>(Arrays.asList(role.getMenuids().split(",")));
        String menuss = StringUtils.join(menuList.toArray(), ",");
        role.setMenuids(menuss);
        int i = 0;
        if (role.getId() == null) {
            i = roleMapper.insertSelective(role);
        } else {
            i = roleMapper.updateByPrimaryKeySelective(role);
        }
        if (i < 1) {
            return GetRest.getFail("保存角色信息出错");
        }
        return GetRest.getSuccess("保存成功");
    }

    /**
     * 启用/禁用角色
     * @param id 角色id
     * @param status 状态
     * @return com.project.rest.RestResponse
     */
    public RestResponse updateRoleStatus(Integer id, Integer status) {
        Role role = roleMapper.selectByPrimaryKey(id);
        if (role == null) {
            return GetRest.getFail("角色不存在");
        }
        role.setStatus(status);
        int i = roleMapper.updateByPrimaryKeySelective(role);
        if (i < 1) {
            return GetRest.getFail("操作失败");
        }
        return GetRest.getSuccess("操作成功");
    }

    /**
     * 删除角色
     * @param id 角色id
     * @return com.project.rest.RestResponse
     */
    public RestResponse deleteRole(Integer id) {
        int i = roleMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            return GetRest.getFail("删除失败");
        }
        return GetRest.getSuccess("删除成功");
    }

    /**
     * 查询角色
     * @param id 角色id
     * @return com.project.entity.Role
     */
    public Role queryRole(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询菜单列表
     * @param role 角色对象
     * @return java.util.List<com.project.entity.Menu>
     */
    public List<Menu> queryMenuList(Role role) {
        String menuIds = "";
        if (role != null) {
            menuIds = "," + role.getMenuids() + ",";
        }
        MenuExample example = new MenuExample();
        example.createCriteria().andStatusEqualTo(StaticUtils.status_yes);
        example.setOrderByClause("id asc,type asc");
        List<Menu> list = menuMapper.selectByExample(example);
        for (Menu m : list) {
            String menu = "," + m.getId() + ",";
            // 判断是否有该权限
            if (menuIds.indexOf(menu) > -1) {
                m.setCheck("checked");
            }
        }
        return list;
    }
}
