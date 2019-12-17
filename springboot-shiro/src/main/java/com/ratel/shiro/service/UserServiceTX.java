package com.ratel.shiro.service;

import com.ratel.shiro.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @业务描述：
 * @package_name： com.ratel.shiro.service
 * @project_name： springboot-action
 * @author： ratelfu@qq.com
 * @create_time： 2019-12-17 17:56
 * @copyright (c) ratelfu 版权所有
 */
@Service
public class UserServiceTX {

    @Autowired
    private UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    public void a1(){
        userDao.update();
    }


    public void a2(){
        userDao.update();
    }
}
