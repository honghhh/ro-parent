package com.project.interceptor;

import com.project.exception.ThrowJsonException;
import com.project.exception.ThrowPageException;
import com.project.session.CmsSession;
import com.project.utils.MappingUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 菜单拦截器
 */
public class MenuInterceptor implements HandlerInterceptor {

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
        Integer userid = CmsSession.getUserId(request);
        // 获取请求头信息 看是否为ajax请求
        String type = request.getHeader("X-Requested-With");
        if (userid == null) {
            // 如果为ajax请求
            if ("XMLHttpRequest".equalsIgnoreCase(type)) {
                response.setHeader("sessionstatus", "timeout");
            } else {
                response.sendRedirect(MappingUtil.LOGIN);
            }
            return false;
        } else {
            // 获取请求路径
            String returnUrl = String.valueOf(request.getServletPath());
            List<String> strs = CmsSession.getMenuUrlList(request);
            // strs.add(MappingUtil.verifyImg);
            boolean bool = strs.contains(returnUrl);
            //如果是ajax请求
            if ("XMLHttpRequest".equalsIgnoreCase(type)) {
                if (!bool) {
                    throw new ThrowJsonException("您还没有此功能权限不能操作");
                }
            } else {
                if (!bool) {
                    throw new ThrowPageException("您还没有此功能权限不能操作");
                }
            }
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
