package com.youyuan.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhangyu
 * @version 1.0
 * @description 沃基地补发站内信实体信息
 * @date 2019/3/6 10:55
 */
@Entity
@Table(name = "BUS_ORDER_MS_20190305")
public class Order implements Serializable {
    private static final long serialVersionUID = -959621162156144959L;

    @Id
    @Column(name = "ORDER_ID")
    private String orderId;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "ADD_TIME")
    private String addTime;
    @Column(name = "STATE")
    private Integer state;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", addTime='" + addTime + '\'' +
                ", state=" + state +
                '}';
    }
}
