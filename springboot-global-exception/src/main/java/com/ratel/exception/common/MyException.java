package com.ratel.exception.common;

/**
 * @业务描述： 自定义异常
 * @package_name： com.ratel.exception.common
 * @project_name： springboot-action
 * @author： ratelfu@qq.com
 * @create_time： 2019-12-16 16:49
 * @copyright (c) ratelfu 版权所有
 */
public class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }

}