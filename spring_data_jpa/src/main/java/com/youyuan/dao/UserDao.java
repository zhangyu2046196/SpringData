package com.youyuan.dao;

import com.youyuan.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangyu
 * @version 1.0
 * @description  SpringData JPA定义的接口
 * JpaRepository 泛型的第一个参数为要操作的实体  第二个参数为实体主键类型
 * @date 2019/3/7 15:41
 */
public interface UserDao extends JpaRepository<Users,Integer> {

}
