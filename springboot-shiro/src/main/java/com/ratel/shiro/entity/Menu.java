package com.ratel.shiro.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @业务描述：
 * @package_name： com.ratel.shiro.entity
 * @project_name： springboot-action
 * @author： ratelfu@qq.com
 * @create_time： 2019-12-18 15:56
 * @copyright (c) ratelfu 版权所有
 */
@Data
@NoArgsConstructor
public class Menu implements Serializable {

    private String  id;
    private String name;
    private String pid;
    private List<Menu> menuChildren;


}
