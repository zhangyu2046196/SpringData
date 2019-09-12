package com.youyuan.dao;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description 自定义Repository接口实现类
 * @date 2019/3/8 20:01
 */
@Service
public class MyRepositoryImpl<T> implements MyRepository<T> {

    @PersistenceContext(name="entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public T findById(Class<T> tClass, Integer id) {
        return entityManager.find(tClass,id);
    }
}
