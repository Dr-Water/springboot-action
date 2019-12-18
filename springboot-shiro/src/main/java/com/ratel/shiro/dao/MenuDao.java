package com.ratel.shiro.dao;

import com.ratel.shiro.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @业务描述：
 * @package_name： com.ratel.shiro.dao
 * @project_name： springboot-action
 * @author： ratelfu@qq.com
 * @create_time： 2019-12-18 16:03
 * @copyright (c) ratelfu 版权所有
 */
@Mapper
public interface MenuDao {

    /**
     * 根据父类id查询子类菜单
     * @param pid
     * @return
     */
     List<Menu> selectByPid(Integer pid);

    /**
     * 查询所有的菜单
     * @return
     */
     List<Menu> selectAll();

    /**
     * 查询除了一级菜单以外的菜单
     * @return
     */
     List<Menu> selectAllNotBase();
}
