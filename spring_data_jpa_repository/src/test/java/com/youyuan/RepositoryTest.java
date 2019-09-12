package com.youyuan;

import com.youyuan.dao.UserDao;
import com.youyuan.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description Repository接口测试
 * @date 2019/3/7 21:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class RepositoryTest {

    @Autowired
    private UserDao userDao;

    /**
     * 基于方法名命名规则的查询
     * 需求：查询userName为郭德纲的用户
     */
    @Test
    public void testA(){
        //相等查询有三种方式
        //1、查询条件为空 2、Is 3、Equal
       List<Users> list= userDao.findByUserNameIs("郭德纲");
       for (Users user:list){
           System.out.println(user);
       }
    }

    /**
     * 基于方法命名规则查询
     * 需求：userName进行like查询
     */
    @Test
    public void testB(){
        List<Users> list= userDao.findByUserNameLike("%在线%");
        for (Users user:list){
            System.out.println(user);
        }
    }

    /**
     * 基于方法名命名规则查询
     * 需求：查询userName为郭德纲并且userAge>32的用户
     */
    @Test
    public void testC(){
        List<Users> list=userDao.findByUserNameAndUserAgeGreaterThanEqual("郭德纲",32);
        for (Users user:list){
            System.out.println(user);
        }
    }

    /**
     * 基于@Query注解查询 JPQL查询
     * 需求：查询userName为郭德纲的用户
     */
    @Test
    public void testD(){
        List<Users> list= userDao.queryByUserNameUseJpql("郭德纲");
        for (Users user:list){
            System.out.println(user);
        }
    }

    /**
     * 基于@Query注解查询 JPQL查询
     * 需求：userName进行like查询
     */
    @Test
    public void testE(){
        List<Users> list= userDao.queryByUserNameLikeUseJpql("%在线%");
        for (Users user:list){
            System.out.println(user);
        }
    }

    /**
     * 基于@Query注解查询 JPQL查询
     * 需求：查询userName为郭德纲并且userAge>32的用户
     */
    @Test
    public void testF(){
        List<Users> list=userDao.queryByUserNameAndAgeUseJpql("郭德纲",32);
        for (Users user:list){
            System.out.println(user);
        }
    }

    /**
     * 基于@Query注解查询 SQL查询
     * 需求：查询userName为郭德纲的用户
     */
    @Test
    public void testG(){
        List<Users> list= userDao.queryByUserNameUseSql("郭德纲");
        for (Users user:list){
            System.out.println(user);
        }
    }

    /**
     * 基于@Query注解查询 SQL查询
     * 需求：userName进行like查询
     */
    @Test
    public void testH(){
        List<Users> list= userDao.queryByUserNameLikeUseSql("%在线%");
        for (Users user:list){
            System.out.println(user);
        }
    }

    /**
     * 基于@Query注解查询 SQL查询
     * 需求：查询userName为郭德纲并且userAge>32的用户
     */
    @Test
    public void testK(){
        List<Users> list=userDao.queryByUserNameAndUserAgeUseSql("郭德纲",32);
        for (Users user:list){
            System.out.println(user);
        }
    }

    @Test
    @Transactional
    @Rollback(false)
    public void updateUserAgeByUserId(){
        userDao.updateUserAgeByUserId(32,5);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void deleteUserByUserId(){
        userDao.deleteUserByUserId(4);
    }
}
