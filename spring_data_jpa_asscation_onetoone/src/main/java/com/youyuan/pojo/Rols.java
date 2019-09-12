package com.youyuan.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhangyu
 * @version 1.0
 * @description 角色实体信息
 * @date 2019/3/9 9:29
 */
@Entity
@Table(name = "t_rols")
public class Rols implements Serializable {
    private static final long serialVersionUID = -2933878298884561280L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rols_id")
    private Integer rolsId;

    @Column(name = "rols_name")
    private String rolsName;
    //OnToOne代表一对一关联关系，mappedBy代表与users对象中的哪个属性关联
    @OneToOne(mappedBy = "rols")
    private Users users;

    public Integer getRolsId() {
        return rolsId;
    }

    public void setRolsId(Integer rolsId) {
        this.rolsId = rolsId;
    }

    public String getRolsName() {
        return rolsName;
    }

    public void setRolsName(String rolsName) {
        this.rolsName = rolsName;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Rols{" +
                "rolsId=" + rolsId +
                ", rolsName='" + rolsName + '\'' +
                '}';
    }
}
