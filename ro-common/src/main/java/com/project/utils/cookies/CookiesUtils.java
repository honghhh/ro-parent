package com.project.utils.cookies;

import com.project.utils.pwd.DESEncode;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesUtils {

    public static final String cookies_domain = "globalfishnet.com";
    private static final String cookie_key = "userticket";
    private static final String language_cookie_key = "languageticket";
    private static final String macurl_cookie_key = "macurlticket";

    /**************************************************** 用户 ********************************************************/
    /**
     * 保存cookies
     * @param response
     * @param id
     */
    public static void setUserCookies(HttpServletResponse response, Integer id) {
        String idstr = DESEncode.encrypt(String.valueOf(id));
        Cookie name = new Cookie(cookie_key, idstr);
        name.setDomain(cookies_domain);
        name.setPath("/");
        response.addCookie(name);
    }

    /**
     * 取ticket
     * @param request
     * @return
     */
    public static String getCookies(HttpServletRequest request) {
        try {
            Cookie[] cookies = request.getCookies();
            String cookiesString = "";
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    Cookie c = cookies[i];
                    if (c.getName().equalsIgnoreCase(cookie_key)) {
                        cookiesString = c.getValue();
                        break;
                    }
                }
            }
            return cookiesString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 移除ticket
     * @param request
     * @param response
     */
    public static void removeCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                String cookieName = cookies[i].getName();
                if (cookieName.equals(cookie_key)) {
                    cookies[i].setValue(null);
                    cookies[i].setPath("/");
                    cookies[i].setDomain(cookies_domain);
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                }
            }
        }
    }

    /************************************************** 语种 ****************************************************************/
    /**
     * 保存cookies
     * @param response
     */
    public static void setLanguageCookies(HttpServletResponse response, String language) {
        Cookie name = new Cookie(language_cookie_key, language);
        name.setDomain(cookies_domain);
        name.setPath("/");
        response.addCookie(name);
    }

    /**
     * 取ticket
     *
     * @param request
     * @return
     */
    public static String getLanguageCookies(HttpServletRequest request) {
        try {
            Cookie[] cookies = request.getCookies();
            String cookiesString = "";
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    Cookie c = cookies[i];
                    if (c.getName().equalsIgnoreCase(language_cookie_key)) {
                        cookiesString = c.getValue();
                        break;
                    }
                }
            }
            return cookiesString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 移除ticket
     *
     * @param request
     * @param response
     */
    public static void removeLanguageCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                String cookieName = cookies[i].getName();
                if (cookieName.equals(language_cookie_key)) {
                    cookies[i].setValue(null);
                    cookies[i].setPath("/");
                    cookies[i].setDomain(cookies_domain);
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                }
            }
        }
    }

    /******************************************************** 机器 ****************************************************/
    /**
     * 保存cookies
     * @param response
     */
    public static void setMacurlCookies(HttpServletResponse response, String macurl) {
        String idstr = DESEncode.encrypt(macurl);
        Cookie name = new Cookie(macurl_cookie_key, idstr);
        name.setDomain(cookies_domain);
        name.setPath("/");
        response.addCookie(name);
    }

    /**
     * 取ticket
     * @param request
     * @return
     */
    public static String getMacurlCookies(HttpServletRequest request) {
        try {
            Cookie[] cookies = request.getCookies();
            String cookiesString = "";
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    Cookie c = cookies[i];
                    if (c.getName().equalsIgnoreCase(macurl_cookie_key)) {
                        cookiesString = c.getValue();
                        break;
                    }
                }
            }
            return cookiesString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 移除ticket
     * @param request
     * @param response
     */
    public static void removeMacurlCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                String cookieName = cookies[i].getName();
                if (cookieName.equals(macurl_cookie_key)) {
                    cookies[i].setValue(null);
                    cookies[i].setPath("/");
                    cookies[i].setDomain(cookies_domain);
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                }
            }
        }
    }
}
