package com.ratel.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @业务描述：
 * @package_name： com.ratel.shiro.com.ratel.shiro.modules.jwt.controller
 * @project_name： springboot-shiro
 * @author： ratelfu@qq.com
 * @create_time： 2019-12-11 14:23
 * @copyright (c) ratelfu 版权所有
 */
@Controller
@RequestMapping("user")
public class UserConttroller {

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/login.html";
    }

    @RequestMapping("/login")
    public String login(String username,String password,Model model) {
        /**
         * 使用shiro编写认证操作
         */
        //获取Subject
        Subject subject= SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        //执行登录方法
        try {
            //只要执行login方法，就会去执行UserRealm中的认证逻辑
            subject.login(token);

            //如果没有异常，代表登录成功
            //跳转到textThymeleaf页面，代表主页
            return "redirect:/testThymeleaf.html";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            //登录失败
            model.addAttribute("msg","用户名不存在");
            return "/login.html";

        }catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            model.addAttribute("msg","密码错误");
            return "/login.html";
        }
    }

    @RequestMapping("/add")
    public String add() {
        return "/add.html";
    }

    @RequestMapping("/update")
    public String update() {
        return "/update.html";
    }

}
