package com.youyuan.pojo;



import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhangyu
 * @version 1.0
 * @description Users实体对象信息
 * @date 2019/3/5 22:40
 */
@Entity
@Table(name = "t_users")
public class Users implements Serializable {
    private static final long serialVersionUID = -4465030137882362967L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增长
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userAge")
    private Integer userAge;

    //OneToOne代表一对一的关联关系,cascade = CascadeType.PERSIST代表打开级联操作, @JoinColumn代表关联的外键，也就是t_rols表主键
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "rols_id")
    private Rols rols;

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

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Rols getRols() {
        return rols;
    }

    public void setRols(Rols rols) {
        this.rols = rols;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", rols=" + rols +
                '}';
    }
}
