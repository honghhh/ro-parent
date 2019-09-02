package com.project.controller;

import com.project.dto.cms.LoginDTO;
import com.project.entity.Menu;
import com.project.service.PlatService;
import com.project.session.CmsSession;
import com.project.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description 首页Handle
 * @author: huangh
 * @since 2019-09-02 15:21
 */
@Controller
public class PlatController {

    @Autowired
    private PlatService platService;

    /**
     * 首页
     * @param request 请求对象
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = MappingUtils.SHOW_INDEX)
    public ModelAndView showIndex(HttpServletRequest request){
        ModelAndView view = new ModelAndView(MappingUtils.SHOW_INDEX);
        List<Menu> menus = CmsSession.getMenuList(request);
        LoginDTO loginDto = CmsSession.getUser(request);
        view.addObject("menus", menus);
        view.addObject("loginDto", loginDto);
        return view;
    }

    /**
     * 欢迎页
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = MappingUtils.SHOW_WELCOME)
    public ModelAndView showWelcome(){
        ModelAndView view = new ModelAndView(MappingUtils.SHOW_WELCOME);
        return view;
    }
}
