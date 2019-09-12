package com.youyuan.service;

import com.youyuan.dao.UsersDao;
import com.youyuan.pojo.Users;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description Users的增删改查实现类
 * @date 2019/3/5 22:49
 */
@Repository
public class UsersDaoImpl implements UsersDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * 保存
     * @param users
     */
    public void insertUsers(Users users) {
        hibernateTemplate.save(users);
    }

    /**
     * 删除
     * @param users
     */
    public void deleteUsers(Users users) {
        hibernateTemplate.delete(users);
    }

    /**
     * 修改
     * @param users
     */
    public void updateUsers(Users users) {
        hibernateTemplate.update(users);
    }

    /**
     * 查询
     * @param userId
     * @return
     */
    public Users selectById(Integer userId) {
        return hibernateTemplate.get(Users.class,userId);
    }

    /**
     * HQL语句
     * @param userName
     * @return
     */
    public List<Users> getUserByName(String userName) {
        //getCurrentSession 当前session必须有一个边界值，并且事务提交或回滚后session自动失效
        //openSession 每次打开一个新的session，用完手动关闭
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        Query query=session.createQuery("from Users u WHERE u.userName=?").setString(0,userName);
        return query.list();
    }

    /**
     * HQL语句查询
     * @param userName
     * @return
     */
    public List<Users> getUserByNameHibernateTemplate(String userName) {
        return (List<Users>) hibernateTemplate.find("from Users u where u.userName=?",userName);
    }

    /**
     * SQL查询
     * @param userName
     * @return
     */
    public List<Users> getUserByNameUseSql(String userName) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        Query query=session.createSQLQuery("select * from t_users where userName=?").addEntity(Users.class).setString(0,userName);
        return query.list();
    }

    /**
     * QBC查询  Query By Criteria
     * @param userName
     * @return
     */
    public List<Users> getUserByNameUseQbc(String userName) {
        Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
        //sql : select * from t_users where userName=''
        Criteria criteria=session.createCriteria(Users.class);
        criteria.add(Restrictions.eq("userName",userName));
        return criteria.list();
    }
}
