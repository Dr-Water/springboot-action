package com.ratel.shiro.service;

import com.ratel.shiro.dao.UserDao;
import com.ratel.shiro.modules.jwt.dao.JwtUserDao;
import com.ratel.shiro.modules.jwt.service.UserService;
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
    private UserServiceTX userServiceTX;

    @Autowired
    private UserDao userDao;

    @Autowired
    private  JwtUserDao  jwtUserDao;

    @Transactional(rollbackFor = Exception.class)
    public void controllerTX(){
        userDao.update();
        //手动抛出一个RuntimeException
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


    /**
     * a没有事务，b有 ，异常发生在b中
     */
    public void a1(){
        userDao.update();
        this.b();
    }

    /**
     * a没有事务，b有 ，异常发生在a中
     */
    public void a2(){
        userDao.update();
        this.b1();
        System.out.println(2/0);
    }


    /**
     * a有事务，b没有 ，异常发生在b中
     */
    @Transactional(rollbackFor = Exception.class)
    public void a3(){
        userDao.update();
        this.b3();
    }

    /**
     * a有事务，b没有 ，异常发生在a中
     */
    @Transactional(rollbackFor = Exception.class)
    public void a4(){
        userDao.update();
        this.b4();
        System.out.println(2/0);
    }


    /**
     * a有事务，b也有 ，异常发生在b中
     */
    @Transactional(rollbackFor = Exception.class)
    public void a5(){
        userDao.update();
        this.b();
    }

    /**
     * a有事务，b也有 ，异常发生在a中
     */
    @Transactional(rollbackFor = Exception.class)
    public void a6(){
        userDao.update();
        this.b1();
        System.out.println(2/0);
    }





    @Transactional(rollbackFor = Exception.class)
    public void b(){
        System.out.println(2/0);
        jwtUserDao.update();
    }


    @Transactional(rollbackFor = Exception.class)
    public void b1(){
        jwtUserDao.update();
    }


    public void b3(){
        jwtUserDao.update();
        System.out.println(2/0);
    }

    public void b4(){
        jwtUserDao.update();
    }

    /**
     *
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public void b5(){
        userServiceTX.a1();
        jwtUserDao.update();
        System.out.println(2/0);
    }

    /**
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public void b6(){
        userServiceTX.a2();
        jwtUserDao.update();
        System.out.println(2/0);
    }


    /**
     *
     */
    public void b7(){
        userServiceTX.a1();
        jwtUserDao.update();
        System.out.println(2/0);
    }


    /**
     *
     */
    public void b8(){
        userServiceTX.a2();
        jwtUserDao.update();
        System.out.println(2/0);
    }
}
