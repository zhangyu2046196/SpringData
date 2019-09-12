package com.youyuan.dao;

import com.youyuan.pojo.Order;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description 沃基地接口
 * @date 2019/3/6 10:58
 */
public interface OrderDao {

    List<Order> getOrderByState(Integer state);

    void updateOrder(Order order);

}
