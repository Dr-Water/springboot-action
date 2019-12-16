package com.ratel.exception.common;

import lombok.Data;

/**
 * @业务描述： 统一的json返回对象
 * @package_name： com.ratel.exception.common
 * @project_name： springboot-action
 * @author： ratelfu@qq.com
 * @create_time： 2019-12-16 16:49
 * @copyright (c) ratelfu 版权所有
 */
@Data
public class ErrorInfo<T> {

    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private Integer code;
    private String message;
    private String url;
    private T data;

}
