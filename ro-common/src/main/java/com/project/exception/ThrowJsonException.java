package com.project.exception;

/**
 * 业务异常类
 * <p>抛接口提示</p>
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
