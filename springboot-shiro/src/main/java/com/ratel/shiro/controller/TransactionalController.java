package com.ratel.shiro.controller;

import com.ratel.shiro.dao.UserDao;
import com.ratel.shiro.modules.jwt.dao.JwtUserDao;
import com.ratel.shiro.service.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

/**
 * @业务描述： 测试@Transactional注解
 * @package_name： com.ratel.shiro.controller
 * @project_name： springboot-action
 * @author： ratelfu@qq.com
 * @create_time： 2019-12-17 14:11
 * @copyright (c) ratelfu 版权所有
 */
@RequestMapping("tx")
@RestController
public class TransactionalController {

    @Autowired
    private TransactionalService transactionalService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private JwtUserDao jwtUserDao;

    @RequestMapping("/tx")
    public void serviceTX(){
        transactionalService.controllerTX();
    }

    @RequestMapping("/tx1")
    public void tx1(){
        transactionalService.tX1();
    }

    @RequestMapping("/tx2")
    public void tX2(){
        transactionalService.tX2();
    }

    @Transactional
    @RequestMapping("/ctx1")
    public void cTX1(){
        userDao.update();
        System.out.println(2/0);
        jwtUserDao.update();
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/ctx2")
    public void cTX2(){
        userDao.update();
        System.out.println(2/0);
        jwtUserDao.update();
    }

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/ctx3")
    public void cTX3() throws FileNotFoundException {
        userDao.update();
        jwtUserDao.update();
        throw new FileNotFoundException("找不到文件");
    }

    @Transactional
    @RequestMapping("/ctx4")
    public void cTX4() throws FileNotFoundException {
        userDao.update();
        jwtUserDao.update();
        throw new FileNotFoundException("找不到文件");
    }





}
