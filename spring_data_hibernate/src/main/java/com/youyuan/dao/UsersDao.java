package com.youyuan.dao;

import com.youyuan.pojo.Users;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description Users增删改查接口
 * @date 2019/3/5 22:47
 */
public interface UsersDao {

    void insertUsers(Users users);

    void deleteUsers(Users users);

    void updateUsers(Users users);

    Users selectById(Integer userId);

    List<Users> getUserByName(String userName);

    List<Users> getUserByNameHibernateTemplate(String userName);

    List<Users> getUserByNameUseSql(String userName);

    List<Users> getUserByNameUseQbc(String userName);

}
