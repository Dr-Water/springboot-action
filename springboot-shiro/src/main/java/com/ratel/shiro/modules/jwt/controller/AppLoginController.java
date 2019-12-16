

package com.ratel.shiro.modules.jwt.controller;


import com.ratel.shiro.common.utils.R;
import com.ratel.shiro.common.validator.ValidatorUtils;
import com.ratel.shiro.modules.jwt.form.LoginForm;
import com.ratel.shiro.modules.jwt.service.UserService;
import com.ratel.shiro.modules.jwt.utils.JwtUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * APP登录授权
 *
 *
 */
@RestController
@RequestMapping("/app")
public class AppLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 登录
     */
    @PostMapping("login")
    public R login(@RequestBody LoginForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        //用户登录
        long userId = userService.login(form);

        //生成token
        String token = jwtUtils.generateToken(userId);

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());

        return R.ok(map);
    }


    public static void main(String[] args) {
        System.out.println( DigestUtils.sha256Hex("123456"));

    }
}
