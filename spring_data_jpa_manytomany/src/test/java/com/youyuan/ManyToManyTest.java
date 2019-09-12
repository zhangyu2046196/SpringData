package com.youyuan;

import com.youyuan.dao.RolsDao;
import com.youyuan.pojo.Menus;
import com.youyuan.pojo.Rols;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhangyu
 * @version 1.0
 * @description 多对多测试
 * @date 2019/3/9 11:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class ManyToManyTest {

    @Autowired
    private RolsDao rolsDao;

    @Test
    public void insertTest(){
        //创建角色
        Rols rols=new Rols();
        rols.setRolsName("销售部");
        Rols rols1=new Rols();
        rols1.setRolsName("技术部");
        //创建菜单
        Menus menus=new Menus();
        menus.setMenuName("线上友缘管理平台");
        menus.setFasterId(-1);

        Menus menus1=new Menus();
        menus1.setMenuName("营销菜单栏目");
        menus1.setFasterId(1);
        menus1.setMenuUrl("admin/sa.do");

        //创建关系
        rols.getMenusSet().add(menus);
        rols.getMenusSet().add(menus1);
        rols1.getMenusSet().add(menus1);
        menus.getRolsSet().add(rols);
        menus.getRolsSet().add(rols1);
        menus1.getRolsSet().add(rols);

        //保存

        rolsDao.save(rols);
        rolsDao.save(rols1);

    }

}
