package com.project.controller;

import com.project.dto.cms.LoginDto;
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

@Controller
public class PlatController {

    @Autowired
    private PlatService platService;

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = MappingUtils.SHOW_INDEX)
    public ModelAndView showIndex(HttpServletRequest request){
        ModelAndView view = new ModelAndView(MappingUtils.SHOW_INDEX);
        List<Menu> menus = CmsSession.getMenuList(request);
        LoginDto loginDto = CmsSession.getUser(request);
        view.addObject("menus", menus);
        view.addObject("loginDto", loginDto);
        return view;
    }

    /**
     * 欢迎页
     * @return
     */
    @RequestMapping(value = MappingUtils.SHOW_WELCOME)
    public ModelAndView showWelcome(){
        ModelAndView view = new ModelAndView(MappingUtils.SHOW_WELCOME);
        return view;
    }
}
