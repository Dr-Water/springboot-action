package com.ratel.shiro.controller;

import com.ratel.shiro.dao.MenuDao;
import com.ratel.shiro.entity.Menu;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @业务描述：
 * @package_name： com.ratel.shiro.controller
 * @project_name： springboot-action
 * @author： ratelfu@qq.com
 * @create_time： 2019-12-18 16:08
 * @copyright (c) ratelfu 版权所有
 */
@RestController
@RequestMapping("mymenu")
public class MenuController {

    @Autowired
    private MenuDao menuDao;


    @RequestMapping("/getMenuTree")
    public List<Menu> getMenuTree(){
        List<Menu> menusBase = menuDao.selectByPid(0);
        List<Menu> menuLNotBase = menuDao.selectAllNotBase();
        for (Menu menu : menusBase) {
            List<Menu> menus = iterateMenus(menuLNotBase, menu.getId());
            menu.setMenuChildren(menus);
        }
        return  menusBase;
    }


    /**
     *多级菜单查询方法
     * @param menuVoList 不包含最高层次菜单的菜单集合
     * @param pid 父类id
     * @return
     */
    public List<Menu> iterateMenus(List<Menu> menuVoList,String pid){
        List<Menu> result = new ArrayList<Menu>();
        for (Menu menu : menuVoList) {
            //获取菜单的id
            String menuid = menu.getId();
            //获取菜单的父id
            String parentid = menu.getPid();
            if(StringUtils.isNotBlank(parentid)){
                if(parentid.equals(pid)){
                    //递归查询当前子菜单的子菜单
                    List<Menu> iterateMenu = iterateMenus(menuVoList,menuid);
                    menu.setMenuChildren(iterateMenu);
                    result.add(menu);
                }
            }
        }
        return result;
    }




}
