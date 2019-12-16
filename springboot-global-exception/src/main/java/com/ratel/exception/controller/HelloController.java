package com.ratel.exception.controller;

import com.ratel.exception.common.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @业务描述： 测试的Controller
 * @package_name： com.ratel.exception.controller
 * @project_name： springboot-action
 * @author： ratelfu@qq.com
 * @create_time： 2019-12-16 16:50
 * @copyright (c) ratelfu 版权所有
 */
@RestController
public class HelloController {

    @RequestMapping("/json")
    public String json() throws Exception {
        throw new MyException("发生错误2");
    }

    @RequestMapping("/json2")
    public Integer json2(){
        return 2/0;
    }

}