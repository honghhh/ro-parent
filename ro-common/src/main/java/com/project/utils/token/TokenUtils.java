package com.project.utils.token;

import cn.jiguang.common.utils.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @description Token工具类
 * @author: huangh
 * @since 2019-09-02 16:01
 */
public class TokenUtils {

	/**
	 * 从request中获取token
	 * @param request
	 * @return
	 */
	public static String getToken(HttpServletRequest request) {
		// 先从头里面取
		String token = request.getHeader("token") ;
		if(StringUtils.isNotEmpty(token)) {
			return token ;
		}

		/**
		 * 再从cookie里面取
		 */
		if(token == null) {
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for (Cookie cookie : cookies) {
					if ("token".equals(cookie.getName())) {
						token = cookie.getValue() ;
						return token ;
					}
				}
			}
		}
		return null ;
	}
}
