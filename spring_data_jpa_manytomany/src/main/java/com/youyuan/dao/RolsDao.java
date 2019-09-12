package com.youyuan.dao;

import com.youyuan.pojo.Rols;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangyu
 * @version 1.0
 * @description 多对多关系接口
 * @date 2019/3/9 11:22
 */
public interface RolsDao extends JpaRepository<Rols,Integer> {

}
