package com.project.controller;

import com.github.pagehelper.PageInfo;
import com.project.entity.Log;
import com.project.service.LogService;
import com.project.utils.LogMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @description 操作日志Handle
 * @author: huangh
 * @since 2019-09-05 11:32
 */
@Controller
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 操作日志列表页面
     * @param log 搜索信息
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = LogMapping.SHOW_LOG_LIST)
    public ModelAndView showLogList(Log log) {
        ModelAndView view = new ModelAndView(LogMapping.SHOW_LOG_LIST);
        List<Log> list = logService.queryLogList(log);
        PageInfo<Log> pageInfo = new PageInfo<Log>(list);
        view.addObject("pageInfo", pageInfo);
        view.addObject("log", log);
        return view;
    }
}
