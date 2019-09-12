package com.youyuan;

import com.youyuan.dao.UserDao;
import com.youyuan.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description CrudRepository接口测试信息
 * @date 2019/3/8 14:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class CrudRepositoryTest {

    @Autowired
    private UserDao userDao;

    /**
     * 测试添加信息
     */
    @Test
    public void insertTest(){
        Users u1=new Users();
        u1.setUserName("上海");
        u1.setUserAge(29);
        Users u2=new Users();
        u2.setUserName("广州");
        u2.setUserAge(36);
        List<Users> list=new ArrayList<Users>();
        list.add(u1);
        list.add(u2);
        userDao.save(list);
    }

    @Test
    public void updateTest(){
        Users users=new Users();
        users.setUserName("香港");
        users.setUserAge(18);
        users.setUserId(7);
        userDao.save(users);
    }


    @Test
    public void find(){
        System.out.println(userDao.findOne(6));
    }

    @Test
    public void findByParamsTest(){
        List<Users> usersList= (List<Users>) userDao.findAll();
        for (Users users:usersList){
            System.out.println(users);
        }
    }

    @Test
    public void deleteById(){
        userDao.delete(7);
    }

}
