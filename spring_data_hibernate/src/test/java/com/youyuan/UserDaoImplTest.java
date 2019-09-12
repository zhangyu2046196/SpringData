package com.youyuan;

import com.youyuan.dao.UsersDao;
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
 * @description 测试Users的增删改操作
 * @date 2019/3/5 23:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class UserDaoImplTest {

    @Autowired
    private UsersDao usersDao;

    /**
     * 保存
     */
    @Test
    @Transactional  //在单元测试 事务默认是回滚
    @Rollback(false) //关闭事务默认回滚
    public void insertUsersTest(){
        Users users=new Users();
        users.setUserName("友缘在线科技有限公司");
        users.setUserAge(9);
        usersDao.insertUsers(users);
    }

    /**
     * 修改
     */
    @Test
    @Transactional  //在单元测试 事务默认是回滚
    @Rollback(false) //关闭事务默认回滚
    public void updateUsersTest(){
        Users users=new Users();
        users.setUserId(1);
        users.setUserName("友缘有限公司");
        users.setUserAge(12);
        usersDao.updateUsers(users);
    }

    /**
     * 查询
     */
    @Test
    public void selectUsersByIdTest(){
        Users users=usersDao.selectById(1);
        System.out.println(users);
    }

    /**
     * 删除
     */
    @Test
    @Transactional
    @Rollback(false)
    public void deleteUsersTest(){
        Users users=new Users();
        users.setUserId(1);
        usersDao.deleteUsers(users);
    }

    @Test
    @Transactional
    public void getUserByUserNameTest(){
        List<Users> list=usersDao.getUserByName("友缘在线科技有限公司");
        for (Users users:list){
            System.out.println(users);
        }
    }

    @Test
    @Transactional
    public void getUserByUserNameHibernateTemplate(){
        List<Users> list=usersDao.getUserByNameHibernateTemplate("友缘在线科技有限公司");
        for (Users users:list){
            System.out.println(users);
        }
    }

    @Test
    @Transactional
    public void getUserByNameUseSql(){
        List<Users> list=usersDao.getUserByNameUseSql("友缘在线科技有限公司");
        for (Users users:list){
            System.out.println(users);
        }
    }

    @Test
    @Transactional
    public void getUserByNameUseQbc(){
        List<Users> list=usersDao.getUserByNameUseQbc("友缘在线科技有限公司");
        for (Users users:list){
            System.out.println(users);
        }
    }

}
