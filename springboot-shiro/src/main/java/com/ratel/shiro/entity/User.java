package com.ratel.shiro.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @业务描述：
 * @package_name： com.ratel.shiro.entity
 * @project_name： springboot-shiro
 * @author： ratelfu@qq.com
 * @create_time： 2019-12-11 15:44
 * @copyright (c) ratelfu 版权所有
 */
@Data
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String usename;
    private String password;

}
