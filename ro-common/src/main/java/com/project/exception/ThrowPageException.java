package com.project.exception;

/**
 * @description 业务异常类 抛页面提示
 * @author: huangh
 * @since 2019-09-02 15:42
 */
public class ThrowPageException extends RuntimeException {

	/**  */
	private static final long serialVersionUID = -100509897248249450L;

	public ThrowPageException(String arg0){
		super(arg0);
	}

	public ThrowPageException(){
		super();
	}

	public ThrowPageException(Throwable arg0){
		super(arg0);
	}
}
