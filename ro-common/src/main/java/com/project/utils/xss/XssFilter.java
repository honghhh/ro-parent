package com.project.utils.xss;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description 防XSS入驻
 * @author: huangh
 * @since 2019-09-02 16:01
 */
public class XssFilter implements Filter {
	FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new XssHttpServletRequestWrapper(
                (HttpServletRequest) request), response);
    }
}
