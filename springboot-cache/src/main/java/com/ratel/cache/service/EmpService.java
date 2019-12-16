package com.ratel.cache.service;

import com.ratel.cache.dao.EmpDao;
import com.ratel.cache.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @业务描述：
 * @package_name： com.ratel.cache.service
 * @project_name： springboot-learn
 * @author： ratelfu@qq.com
 * @create_time： 2019-11-26 16:51
 * @copyright (c) ratelfu 版权所有
 */
@CacheConfig(cacheNames = "emp")
@Service
public class EmpService {

    @Autowired
    EmpDao empDao;

    //@Cacheable(value = "emp")
    @Cacheable
    public Employee getById(Integer id) {
        return empDao.getById(id);
    }

    @CachePut
    public void save(Employee employee) {
        empDao.save(employee);
    }

    //@CacheEvict
    //这个方法的返回值必须是除了void以外的，否则就会清空缓存中的数据，
    //明天接着验证
    @CachePut(key = "#id")
    public Integer update(Integer id) {
        empDao.update(id);
        return id;
    }
}
