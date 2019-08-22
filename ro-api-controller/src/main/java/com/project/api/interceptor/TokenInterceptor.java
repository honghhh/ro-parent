package com.project.api.interceptor;

import com.project.rest.RestResponse;
import com.project.session.ApiSession;
import com.project.utils.FunctionUtils;
import com.project.utils.redis.RedisUtil;
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
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取token
        String token = TokenUtils.getToken(request);
        // 如果token不存在
        if (StringUtils.isBlank(token)) {
            FunctionUtils.responseMessage(response, new RestResponse(false, "token已失效", "", "403"));
            return false;
        }
        // 从session中获取用户id
        Integer userId = ApiSession.getUserId(request);
        // 取出缓存的值
        String val = (String) redisUtil.get(userId.toString());
        // 如果找不到缓存已过期
        if (StringUtils.isBlank(val)) {
            FunctionUtils.responseMessage(response, new RestResponse(false, "token已失效", "", "403"));
            return false;
        }
        // token校验错误
        if (!val.equals(token)) {
            FunctionUtils.responseMessage(response, new RestResponse(false, "token校验错误", "", "403"));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
