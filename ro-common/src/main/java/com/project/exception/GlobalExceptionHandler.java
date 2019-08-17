package com.project.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.project.rest.GetRest;
import com.project.rest.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONException;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestResponse errorResponse(HttpServletRequest req, Exception e) {
	    e.printStackTrace();
	    return GetRest.getFail("请求错误");
    }

	@ExceptionHandler(value = {IOException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestResponse exception(Exception exception) {
	    return GetRest.getFail("流处理异常");
    }

	/**
     * 处理json异常
     * @param e
     * @return
     */
    @ExceptionHandler(JSONException.class)
    @ResponseBody
    public RestResponse handleBusinessException(JSONException e){
        return GetRest.getFail(e.getMessage());
    }

	/**
     * 处理接口异常
     * @param e
     * @return
     */
    @ExceptionHandler(ThrowJsonException.class)
    @ResponseBody
    public RestResponse handleBusinessException(ThrowJsonException e){
        return GetRest.getFail(e.getMessage());
    }

    /**
     * 处理页面异常
     * @param e
     * @return
     */
    @ExceptionHandler(ThrowPageException.class)
    @ResponseBody
    public ModelAndView showPageException(ThrowPageException e){
        ModelAndView view = new ModelAndView("exception");
        return view;
    }
}
