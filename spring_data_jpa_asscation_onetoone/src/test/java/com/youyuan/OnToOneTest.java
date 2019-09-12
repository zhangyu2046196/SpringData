package com.youyuan;

import com.youyuan.dao.UserDao;
import com.youyuan.pojo.Rols;
import com.youyuan.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhangyu
 * @version 1.0
 * @description 测试一对一测试类
 * @date 2019/3/9 9:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class OnToOneTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void insertTest(){
        //创建用户
        Users users=new Users();
        users.setUserAge(28);
        users.setUserName("李小强");
        //创建角色
        Rols rols=new Rols();
        rols.setRolsName("管理员");
        //建立关系
        users.setRols(rols);
        rols.setUsers(users);
        //保存
        userDao.save(users);
    }

    @Test
    public void findTest(){
        Users users=userDao.findOne(8);
        System.out.println(users);
    }
}
