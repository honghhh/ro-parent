package com.project.exception;

import com.alibaba.fastjson.JSONException;
import com.project.rest.GetRest;
import com.project.rest.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description 全局异常类
 * @author: huangh
 * @since 2019-09-02 15:41
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
