package com.youyuan.dao;

import com.youyuan.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangyu
 * @version 1.0
 * @description 一对多接口
 * @date 2019/3/9 10:22
 */
public interface UserDao extends JpaRepository<Users,Integer>{

}
