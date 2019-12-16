package com.ratel.shiro.config;

import com.ratel.shiro.dao.UserDao;
import com.ratel.shiro.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @业务描述：
 * @package_name： com.ratel.shiro.config
 * @project_name： springboot-shiro
 * @author： ratelfu@qq.com
 * @create_time： 2019-12-11 14:15
 * @copyright (c) ratelfu 版权所有
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserDao userDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        //先写模拟数据进行验证，下一步再连接数据库，假设数据库的用户名和密码如下
        //String dbusername="admin";
        //String dbpassword="123456";

        //编写shiro判断逻辑，判断用户名和密码

        //1. 判断用户名
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        User userDB = userDao.selectByUserName(username);


        if (userDB == null) {
            //用户不存在, shiro底层会抛出UnknownAccountException
            return null;
        }
        String passwordDB = userDB.getPassword();

        //2. 判断密码
        //参数1：需要返回给login方法的数据；参数2：数据库密码，shiro会自动判断
        return new SimpleAuthenticationInfo("", passwordDB, "");

    }
}
