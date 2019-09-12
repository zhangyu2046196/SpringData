package com.youyuan.dao;


import com.youyuan.pojo.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description  SpringData JPA定义的接口
 * Repository 泛型的第一个参数为要操作的实体  第二个参数为实体主键类型  是Spring Data JPA的顶层接口
 * @date 2019/3/7 15:41
 */
public interface UserDao extends Repository<Users,Integer>{

    //基于方法名称命名规则查询
    List<Users> findByUserNameIs(String userName);
    List<Users> findByUserNameLike(String userName);
    List<Users> findByUserNameAndUserAgeGreaterThanEqual(String userName,Integer userAge);

    //基于@Query注解JPQL查询
    @Query("from Users where userName=?")
    List<Users> queryByUserNameUseJpql(String userName);
    @Query("from Users where userName like ?")
    List<Users> queryByUserNameLikeUseJpql(String userName);
    @Query("from Users where userName=? and userAge>=?")
    List<Users> queryByUserNameAndAgeUseJpql(String userName,Integer userAge);

    //基于@Query注解SQL查询
    //nativeQuery 查询方式true为sql查询  false为jpql查询  默认为false
    @Query(value = "select * from t_users where userName=?",nativeQuery = true)
    List<Users> queryByUserNameUseSql(String userName);
    @Query(value = "select * from t_users where userName like ?",nativeQuery = true)
    List<Users> queryByUserNameLikeUseSql(String userName);
    @Query(value = "select * from t_users where userName=? and userAge>=?",nativeQuery = true)
    List<Users> queryByUserNameAndUserAgeUseSql(String userName,Integer userAge);

    //基于@Query注解的数据更新
    @Query("update Users set userAge=? where userId=?")
    @Modifying  //此注解用于标注语句为更新语句
    void updateUserAgeByUserId(Integer userAge,Integer userId);
    @Query("delete Users where userId=?")
    @Modifying
    void deleteUserByUserId(Integer userId);
}
