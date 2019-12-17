

package com.ratel.shiro.modules.jwt.dao;


import com.ratel.shiro.modules.jwt.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户
 *
 *
 */
@Mapper
public interface JwtUserDao  {

    UserEntity selectOne(@Param("phoneNum") String phoneNum);
    UserEntity selectById(Integer id);


    /**
     * 用于测试@Transactional
     * @return
     */
    boolean update();

}
