package com.youyuan.service;

import com.youyuan.dao.OrderDao;
import com.youyuan.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description 沃基地订单接口实现类信息
 * @date 2019/3/6 11:01
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    private final static Integer limitNum=10;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * 查询
     * @param state
     * @return
     */
    public List<Order> getOrderByState(Integer state) {
        String sql="from Order o where o.state=?";
        hibernateTemplate.setMaxResults(limitNum);
        return (List<Order>) hibernateTemplate.find(sql,state);
    }

    /**
     * 更新
     * @param order
     */
    public void updateOrder(Order order) {
        hibernateTemplate.update(order);
    }
}
