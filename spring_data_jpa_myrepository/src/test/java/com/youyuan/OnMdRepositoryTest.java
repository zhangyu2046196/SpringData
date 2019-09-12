package com.youyuan;

import com.youyuan.dao.MyRepository;
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
 * @description 自定义Repository接口测试
 * @date 2019/3/9 8:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class OnMdRepositoryTest {

    @Autowired
    private MyRepository myRepository;

    @Test
    public void findByIdTest(){
        Users users= (Users) myRepository.findById(Users.class,2);
        System.out.println(users);
    }

}
