package com.ratel.exception.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @业务描述： 全局异常处理类
 * @package_name： com.ratel.exception.common
 * @project_name： springboot-action
 * @author： ratelfu@qq.com
 * @create_time： 2019-12-16 16:51
 * @copyright (c) ratelfu 版权所有
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 最大的异常捕获类，用于最后兜底的异常的处理器
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

    /**
     * 用于捕获自己自定的异常，，自定义的异常是处理器可以有多个，发生异常的时候如果匹配到的自定义的异常则不再匹配上面的最大的异常处理器（即：jsonErrorHandler）
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> myjsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data====myjsonErrorHandler");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
}
