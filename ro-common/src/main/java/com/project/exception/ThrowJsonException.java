package com.project.exception;

/**
 * @description 业务异常类 抛接口提示
 * @author: huangh
 * @since 2019-09-02 15:41
 */
public class ThrowJsonException extends RuntimeException {

	/**  */
	private static final long serialVersionUID = -100509897248249450L;

	public ThrowJsonException(String arg0){
		super(arg0);
	}

	public ThrowJsonException(){
		super();
	}

	public ThrowJsonException(Throwable arg0){
		super(arg0);
	}
}
