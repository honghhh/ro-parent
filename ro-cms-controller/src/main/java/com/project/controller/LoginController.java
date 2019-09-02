package com.project.controller;

import com.project.rest.RestResponse;
import com.project.service.LoginService;
import com.project.session.CmsSession;
import com.project.utils.MappingUtils;
import com.project.utils.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @description 登录Handle
 * @author: huangh
 * @since 2019-09-02 15:17
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录页
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = MappingUtils.SHOW_LOGIN)
    public ModelAndView showLogin(){
        ModelAndView view = new ModelAndView(MappingUtils.SHOW_LOGIN);
        return view;
    }

    /**
     * 登录
     * @param request 请求对象
     * @param response 返回对象
     * @param userName 账号
     * @param passWord 密码
     * @return com.project.rest.RestResponse
     */
    @RequestMapping(value = MappingUtils.LOGIN)
    @ResponseBody
    public RestResponse login(HttpServletRequest request, HttpServletResponse response, String userName, String passWord){
        RestResponse result = loginService.login(request, response, userName, passWord);
        return result;
    }

    /**
     * 获取验证码图片
     * @param request 请求对象
     * @param response 返回对象
     * @return void
     */
    @RequestMapping(value = MappingUtils.VERIFY_IMG)
    public void verifyImg(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 创建验证码对象
            VerifyCode verifyCode = new VerifyCode();
            // 创建图片缓存区
            BufferedImage image = verifyCode.getImage();
            // 设置session
            CmsSession.setValidCode(request, verifyCode.getText());
            // 保存图片通过响应输出流输出
            VerifyCode.output(image, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册
     * @param request 请求对象
     * @param userName 账号
     * @param passWord 密码
     * @param code 验证码
     * @return com.project.rest.RestResponse
     */
    @RequestMapping(value = MappingUtils.REGISTER)
    @ResponseBody
    public RestResponse register(HttpServletRequest request, String userName, String passWord, String code) {
        RestResponse result = loginService.register(request, userName, passWord, code);
        return result;
    }

    /**
     * 退出登录
     * @param request 请求对象
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = MappingUtils.LOGOUT)
    @ResponseBody
    public ModelAndView logout(HttpServletRequest request){
        CmsSession.exit(request);
        ModelAndView view = new ModelAndView(MappingUtils.SHOW_LOGIN);
        return view;
    }
}
