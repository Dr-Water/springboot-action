package com.ratel.cache.entity;

import java.io.Serializable;

/**
 * @业务描述：
 * @package_name： com.ratel.cache.entity
 * @project_name： springboot-learn
 * @author： ratelfu@qq.com
 * @create_time： 2019-11-26 16:49
 * @copyright (c) ratelfu 版权所有
 */
public class Employee implements Serializable {
    private Integer id;
    private String name;
    private String sex;
    private String email;

    public Employee() {
    }

    public Employee(Integer id, String name, String sex, String email) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
