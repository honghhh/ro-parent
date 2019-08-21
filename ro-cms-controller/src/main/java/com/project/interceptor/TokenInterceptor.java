package com.project.interceptor;

import com.project.dao.UserMapper;
import com.project.dto.cms.LoginDto;
import com.project.session.CmsSession;
import com.project.utils.MappingUtil;
import com.project.utils.jwt.JwtUtils;
import com.project.utils.token.TokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Token拦截器
 */
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取token
        String token = TokenUtils.getToken(request);
        // 如果token不存在重定向登录页
        if (StringUtils.isBlank(token)) {
            response.sendRedirect(request.getContextPath() + MappingUtil.login_page);
            return false;
        }
        // 从session里获取userId
        Integer userId = CmsSession.getUserId(request);
        if (userId == null) {
            response.sendRedirect(request.getContextPath() + MappingUtil.login_page);
            return false;
        }
        // 从session里去获取用户对象
        LoginDto loginDto = CmsSession.getUser(request);
        try {
            // 校验token
            Boolean verify = JwtUtils.isVerify(token, loginDto);
            // 如果token里的信息与session对象里面不符 验证失败
            if (!verify) {
                response.sendRedirect(request.getContextPath() + MappingUtil.login_page);
                return false;
            }
            return true;
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + MappingUtil.login_page);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
