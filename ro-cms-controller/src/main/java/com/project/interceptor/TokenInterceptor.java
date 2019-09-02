package com.project.interceptor;

import com.project.dto.cms.LoginDTO;
import com.project.session.CmsSession;
import com.project.utils.MappingUtils;
import com.project.utils.jwt.JwtUtil;
import com.project.utils.token.TokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Token拦截器
 */
public class TokenInterceptor implements HandlerInterceptor {

    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     * 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回true
     * 执行下一个拦截器,直到所有的拦截器都执行完毕
     * 再执行被拦截的Controller
     * 然后进入拦截器链,
     * 从最后一个拦截器往回执行所有的postHandle()
     * 接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取token
        String token = TokenUtils.getToken(request);
        // 如果token不存在重定向登录页
        if (StringUtils.isBlank(token)) {
            response.sendRedirect(request.getContextPath() + MappingUtils.SHOW_LOGIN);
            return false;
        }
        // 从session里获取userId
        Integer userId = CmsSession.getUserId(request);
        if (userId == null) {
            response.sendRedirect(request.getContextPath() + MappingUtils.SHOW_LOGIN);
            return false;
        }
        // 从session里去获取用户对象
        LoginDTO loginDto = CmsSession.getUser(request);
        try {
            // 校验token
            Boolean verify = JwtUtil.isVerify(token, loginDto);
            // 如果token里的信息与session对象里面不符 验证失败
            if (!verify) {
                response.sendRedirect(request.getContextPath() + MappingUtils.SHOW_LOGIN);
                return false;
            }
            return true;
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + MappingUtils.SHOW_LOGIN);
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
