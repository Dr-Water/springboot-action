package com.ratel.cache.controller;

import com.ratel.cache.entity.Employee;
import com.ratel.cache.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @业务描述：
 * @package_name： com.ratel.cache.controller
 * @project_name： springboot-learn
 * @author： ratelfu@qq.com
 * @create_time： 2019-11-26 16:54
 * @copyright (c) ratelfu 版权所有
 */
@RestController
@RequestMapping("emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/getById/{id}")
    public Employee getById(@PathVariable("id") Integer id) {
        return empService.getById(id);
    }

    @GetMapping("save")
    public String save(Employee employee) {
        System.out.println(employee);
        empService.save(employee);
        return "success";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id")Integer id) {
        empService.update(id);
        return "success";
    }


}
