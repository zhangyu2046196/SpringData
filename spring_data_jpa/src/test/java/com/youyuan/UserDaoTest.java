package com.youyuan;

import com.youyuan.dao.UserDao;
import com.youyuan.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @author zhangyu
 * @version 1.0
 * @description Users 的测试类信息
 * @date 2019/3/7 15:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @PersistenceContext(name="entityManagerFactory")
    private EntityManager entityManager;

    @Test
    @Transactional
    @Rollback(false)
    public void insertUserTest(){
        Users users=new Users();
        users.setUserName("郭德纲");
        users.setUserAge(39);
        userDao.save(users);
    }


    @Test
    public void theoryTest(){

        //org.springframework.data.jpa.repository.support.SimpleJpaRepository@ddf20fd
        System.out.println(userDao);

        //com.sun.proxy.$Proxy28 代理对象，基于JDK创建的动态代理对象
        System.out.println(userDao.getClass());

        //原理 自己创建UserDao实现类
        JpaRepositoryFactory jpaRepositoryFactory=new JpaRepositoryFactory(entityManager);
        //getRepository()可以为接口生成实现类，这个实现类是SimpleJpaRepository的代理对象
        //要求接口必须继承Repository接口
        UserDao ud=jpaRepositoryFactory.getRepository(UserDao.class);
        System.out.println(ud.getClass());
    }




}
