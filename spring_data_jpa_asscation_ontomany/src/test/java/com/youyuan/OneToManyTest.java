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
 * @description 一对多测试
 * @date 2019/3/9 10:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class OneToManyTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void insertTest(){
        //创建用户
        Users users=new Users();
        users.setUserName("小李");
        users.setUserAge(27);
        //创建角色
        Rols rols=new Rols();
        rols.setRolsName("销售");
        //建立关系
        users.setRols(rols);
        rols.getUsersSet().add(users);
        //保存
        userDao.save(users);
    }

    @Test
    public void findTest(){
        Users users=userDao.findOne(9);
        System.out.println(users);
    }

}
