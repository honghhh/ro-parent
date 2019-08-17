package com.project.session;

import javax.servlet.http.HttpServletRequest;

public class CmsSession {

    /** 验证码 */
    public static final String VALID_CODE = "validCode";

    /**
     * 验证码对象设置session
     */
    public static void setValidCode(HttpServletRequest request, String validCode) {
        request.getSession().removeAttribute(VALID_CODE);
        request.getSession().setAttribute(VALID_CODE, validCode);
    }

    /**
     * 验证码对象获取session
     */
    public static String getValidCode(HttpServletRequest request) {
        return (String) request.getSession().getAttribute(VALID_CODE);
    }
}
