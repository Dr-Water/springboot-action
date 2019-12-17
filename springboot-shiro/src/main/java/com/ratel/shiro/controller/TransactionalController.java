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

    /**
     * 测试@Transactional 注解加到service层事务是否回滚
     */
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

    /**
     * 测试@Transactional 注解加到Controller层事务是否回滚
     * 这里在Controller层为了方便直接调用了dao层，在实际开发中dao层即可在Controller层调用也可以在service层调用，
     * 比如service层只是直接调用dao层一个方法，此外没有任何操作，那么这时候完全不用写service层的方法，直接在Controller调用dao层即可，
     * 当然如果公司有规范，必须严格按照mvc的模式进行开发，则另说
     */
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/ctx2")
    public void cTX2(){
        userDao.update();
        //手动抛出一个RuntimeException
        System.out.println(2/0);
        jwtUserDao.update();
    }

    /**
     * 测试@Transactional加(rollbackFor = Exception.class)事务是否回滚
     * @throws FileNotFoundException
     */
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("/ctx3")
    public void cTX3() throws FileNotFoundException {
        userDao.update();
        jwtUserDao.update();
        throw new FileNotFoundException("找不到文件");
    }

    /**
     * 测试@Transactional不加(rollbackFor = Exception.class)事务是否回滚
     * @throws FileNotFoundException
     */
    @Transactional
    @RequestMapping("/ctx4")
    public void cTX4() throws FileNotFoundException {
        userDao.update();
        jwtUserDao.update();
        throw new FileNotFoundException("找不到文件");
    }

    /**
     * 同类中在方法a中调用b
     * a没有事务，b有 ，异常发生在b中 不会回滚
     */
    @RequestMapping("/a1")
    public void a1(){
        transactionalService.a1();
    }

    /**
     * 同类中在方法a中调用b
     * a没有事务，b有 ，异常发生在a中 不会回滚
     */
    @RequestMapping("/a2")
    public void a2(){
        transactionalService.a2();
    }
    /**
     * 同类中在方法a中调用b
     * a有事务，b没有 ，异常发生在b中 会回滚
     */
    @RequestMapping("/a3")
    public void a3(){
        transactionalService.a3();
    }
    /**
     * 同类中在方法a中调用b
     * a有事务，b没有 ，异常发生在a中 会回滚
     */
    @RequestMapping("/a4")
    public void a4(){
        transactionalService.a4();
    }
    /**
     * 同类中在方法a中调用b
     * a有事务，b也有 ，异常发生在b中 会回滚
     */
    @RequestMapping("/a5")
    public void a5(){
        transactionalService.a5();
    }
    /**
     * 同类中在方法a中调用b
     * a有事务，b也有 ，异常发生在a中 会回滚
     */
    @RequestMapping("/a6")
    public void a6(){
        transactionalService.a6();
    }


    /**
     *a类中调用b类中的方法
     * a中有事务，b中也有 会回滚
     *
     */
    @RequestMapping("/b5")
    public  void b5(){
        transactionalService.b5();
    }

    /**
     *a类中调用b类中的方法
     * a中有事务，b中没有 会回滚
     *
     */
    @RequestMapping("/b6")
    public  void b6(){
        transactionalService.b6();
    }

    /**
     *a类中调用b类中的方法
     * a没有事务，b中有 不会回滚
     *
     */
    @RequestMapping("/b7")
    public  void b7(){
        transactionalService.b7();
    }

    /**
     *a类中调用b类中的方法
     * a没有事务，b中没有 不会回滚
     *
     */
    @RequestMapping("/b8")
    public  void b8(){
        transactionalService.b8();
    }

}
