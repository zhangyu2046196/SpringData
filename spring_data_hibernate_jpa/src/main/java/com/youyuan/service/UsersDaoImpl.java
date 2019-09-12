package com.youyuan.service;

import com.youyuan.dao.UsersDao;
import com.youyuan.pojo.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description Users的增删改查实现类
 * @date 2019/3/5 22:49
 */
@Repository
public class UsersDaoImpl implements UsersDao {

    //@PersistenceContext指定工厂，通过工厂创建EntityManager对象
    @PersistenceContext(name = "entityManagerFactory")
    private EntityManager entityManager;

    /**
     * 保存
     * @param users
     */
    public void insertUsers(Users users) {
        entityManager.persist(users);
    }

    /**
     * 删除
     * @param users
     */
    public void deleteUsers(Users users) {
        Users u=selectById(users.getUserId());
        entityManager.remove(u);
    }

    /**
     * 修改
     * @param users
     */
    public void updateUsers(Users users) {
        entityManager.merge(users);
    }

    /**
     * 查询
     * @param userId
     * @return
     */
    public Users selectById(Integer userId) {
        return entityManager.find(Users.class,userId);
}

    /**
     * HQL语句
     * @param userName
     * @return
     */
    public List<Users> getUserByName(String userName) {
        //Hibernate JPA 使用占位符时位数是从1开始
        return entityManager.createQuery("from Users where userName=?").setParameter(1,userName).getResultList();
    }

    /**
     * HQL语句查询
     * @param userName
     * @return
     */
    public List<Users> getUserByNameHibernateTemplate(String userName) {
        return null;
    }

    /**
     * SQL查询
     * @param userName
     * @return
     */
    public List<Users> getUserByNameUseSql(String userName) {
        //Hibernate JPA 使用占位符时参数位数从1开始
        return entityManager.createNativeQuery("select * from t_users where userName=?",Users.class).setParameter(1,userName).getResultList();
    }

    /**
     * QBC查询  Query By Criteria
     * @param userName
     * @return
     */
    public List<Users> getUserByNameUseQbc(String userName) {
        //CriteriaBuilder对象用于创建CriteriaQuery对象
        CriteriaBuilder builder=entityManager.getCriteriaBuilder();
        //CriteriaQuery对象用于执行查询的Criteria对象
        //select * from t_users
        CriteriaQuery<Users> query=builder.createQuery(Users.class);
        //获取要查询的实体类对象
        Root<Users> root=query.from(Users.class);
        //封装查询条件
        Predicate cate=builder.equal(root.get("userName"),userName);
        //select * from t_users where userName=中国
        query.where(cate);
        //执行查询语句
        TypedQuery<Users> typedQuery=entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
