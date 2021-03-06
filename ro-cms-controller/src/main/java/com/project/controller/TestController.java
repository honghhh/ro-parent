package com.project.controller;

import com.project.entity.User;
import com.project.exception.ThrowJsonException;
import com.project.exception.ThrowPageException;
import com.project.rest.GetRest;
import com.project.rest.RestResponse;
import com.project.service.TestService;
import com.project.utils.BaseUtils;
import com.project.utils.properties.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 测试Handle
 * @author: huangh
 * @since 2019-09-02 15:23
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * 测试spring缓存
     */
    @RequestMapping(value = "/test1")
    @ResponseBody
    public RestResponse test1() {
        RestResponse result = testService.queryUserList();
        return result;
    }

    /**
     * 测试json全局异常
     */
    @RequestMapping(value = "/test2")
    @ResponseBody
    public RestResponse test2() {
        try {
            User user = null;
            System.out.println(user.getPassword());
        } catch (Exception e) {
            throw new ThrowJsonException("json全局异常处理成功");
        }
        return GetRest.getSuccess("");
    }

    /**
     * 测试page全局异常
     */
    @RequestMapping(value = "/test3")
    public ModelAndView test3() {
        ModelAndView view = new ModelAndView("/test3");
        try {
            User user = null;
            System.out.println(user.getPassword());
        } catch (Exception e) {
            throw new ThrowPageException("page全局异常处理成功");
        }
        return view;
    }

    /**
     * 测试国际化
     */
    @RequestMapping(value = "/test4")
    @ResponseBody
    public RestResponse test4(HttpServletRequest request) {
        String base = BaseUtils.getLanguage(request);
        String val1 = PropertiesUtil.getVal("a", "");
        String val2 = PropertiesUtil.getVal("a", "_en");
        String[] arr = {"宝宝"};
        String val3 = PropertiesUtil.getVal("b", arr, "");
        String val4 = PropertiesUtil.getVal("b", arr, "_en");
        String val5 = PropertiesUtil.getProperties("sys-infos_cn", "c");
        String val6 = PropertiesUtil.getProperties("sys-infos_en", "c");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("base", base);
        map.put("val1", val1);
        map.put("val2", val2);
        map.put("val3", val3);
        map.put("val4", val4);
        map.put("val5", val5);
        map.put("val6", val6);
        return GetRest.getSuccess("", map);
    }

    /**
     * 测试aop日志通知
     */
    @RequestMapping(value = "/test5")
    @ResponseBody
    public RestResponse test5() {
        testService.login();
        return GetRest.getSuccess("成功");
    }

    /**
     * 测试redis缓存
     */
    @RequestMapping(value = "/test6")
    @ResponseBody
    public RestResponse test6() {
        List<User> list = testService.queryUserList2();
        return GetRest.getSuccess("成功", list);
    }

    /**
     * 测试消息队列 消息发送
     */
    @RequestMapping(value = "/test7")
    @ResponseBody
    public RestResponse test7() {
        testService.test7();
        return GetRest.getSuccess("成功");
    }

    /**
     * 测试消息队列 消息接受使用监听器QueueMessageListener
     */
    @RequestMapping(value = "/test8")
    @ResponseBody
    public RestResponse test8() {
        testService.test8();
        return GetRest.getSuccess("成功");
    }
}
