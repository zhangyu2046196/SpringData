package com.youyuan.pojo;

import java.io.Serializable;

/**
 * @author zhangyu
 * @version 1.0
 * @description 用户对象信息
 * @date 2019/3/11 16:43
 */
public class User implements Serializable {
    private static final long serialVersionUID = -6331182444095524891L;

    private Integer userId;
    private String userName;
    private Integer age;

    public User(){

    }

    public User(Integer userId, String userName, Integer age) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
