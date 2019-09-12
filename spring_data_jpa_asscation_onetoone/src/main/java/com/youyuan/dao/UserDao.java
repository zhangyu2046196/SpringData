package com.youyuan.dao;

import com.youyuan.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangyu
 * @version 1.0
 * @description 测试一对一接口
 * @date 2019/3/9 9:51
 */
public interface UserDao extends JpaRepository<Users,Integer> {

}
