package com.ratel.cache.dao;

import com.ratel.cache.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @业务描述：
 * @package_name： com.ratel.cache.dao
 * @project_name： springboot-learn
 * @author： ratelfu@qq.com
 * @create_time： 2019-11-26 16:51
 * @copyright (c) ratelfu 版权所有
 */
@Mapper
public interface EmpDao {

    @Select("select * from employee where id =#{id}")
    Employee getById(Integer id);

    @Insert("insert into employee value(#{id},#{name},#{sex},#{email})")
    void save(Employee employee);

    @Update("update employee set sex='2' where id=#{id}")
    void update(Integer id);
}
