package com.youyuan.dao;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description 自定义Repository接口
 * @date 2019/3/8 19:55
 */
public interface MyRepository<T> {

    /**
     * 自定义根据Id查询
     * @param id
     * @param tClass
     * @return
     */
    public T findById(Class<T> tClass,Integer id);

}
