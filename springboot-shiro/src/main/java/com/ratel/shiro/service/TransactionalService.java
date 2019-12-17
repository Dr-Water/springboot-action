package com.ratel.shiro.service;

import com.ratel.shiro.dao.UserDao;
import com.ratel.shiro.modules.jwt.dao.JwtUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @业务描述：
 * @package_name： com.ratel.shiro.service
 * @project_name： springboot-action
 * @author： ratelfu@qq.com
 * @create_time： 2019-12-17 14:12
 * @copyright (c) ratelfu 版权所有
 */
@Service
public class TransactionalService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private  JwtUserDao  jwtUserDao;

    @Transactional(rollbackFor = Exception.class)
    public void controllerTX(){
        userDao.update();
        System.out.println(2/0);
        jwtUserDao.update();
    }


    @Transactional(rollbackFor = {Exception.class})
    public void tX1(){
        userDao.update();
        System.out.println(2/0);
        jwtUserDao.update();
    }

    @Transactional
    public void tX2(){
        userDao.update();
        System.out.println(2/0);
        jwtUserDao.update();
    }







}
