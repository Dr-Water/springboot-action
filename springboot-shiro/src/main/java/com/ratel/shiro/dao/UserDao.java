package com.ratel.shiro.dao;

import com.ratel.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @业务描述：
 * @package_name： com.ratel.shiro
 * @project_name： springboot-shiro
 * @author： ratelfu@qq.com
 * @create_time： 2019-12-11 15:44
 * @copyright (c) ratelfu 版权所有
 */
@Mapper
public interface UserDao {

    User selectById(Integer id);
    User selectByUserName(@Param("username") String userName);

    /**
     * 用于测试@Transactional
     * @return
     */
    boolean update();



}
