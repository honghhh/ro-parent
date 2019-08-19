package com.project.controller;

import com.project.rest.RestResponse;
import com.project.service.LoginService;
import com.project.session.CmsSession;
import com.project.utils.MappingUtil;
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

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录页
     * @return
     */
    @RequestMapping(value = MappingUtil.login_page)
    public ModelAndView loginPage(){
        ModelAndView view = new ModelAndView(MappingUtil.login_page);
        return view;
    }

    /**
     * 登录
     * @param userName 账号
     * @param passWord 密码
     * @return
     */
    @RequestMapping(value = MappingUtil.login)
    @ResponseBody
    public RestResponse login(String userName, String passWord){
        RestResponse result = loginService.login(userName, passWord);
        return result;
    }

    /**
     * 获取验证码图片
     * @param request 请求对象
     * @param response 返回对象
     * @return
     */
    @RequestMapping(value = MappingUtil.verifyImg)
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
     * @return
     */
    @RequestMapping(value = MappingUtil.register)
    @ResponseBody
    public RestResponse register(HttpServletRequest request, String userName, String passWord, String code) {
        RestResponse result = loginService.register(request, userName, passWord, code);
        return result;
    }
}
