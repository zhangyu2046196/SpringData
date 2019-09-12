package com.youyuan;

import com.youyuan.dao.UserDao;
import com.youyuan.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description JpaRepository测试类信息
 * @date 2019/3/8 18:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class JpaRepositoryTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findAllTest(){
        List<Users> usersList=userDao.findAll();
        for (Users users:usersList){
            System.out.println(users);
        }
    }

}
