package com.youyuan.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
    //OneToMany代表一对多关系
    @OneToMany()
    private Set<Users> usersSet=new HashSet<Users>();

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

    public Set<Users> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(Set<Users> usersSet) {
        this.usersSet = usersSet;
    }

    @Override
    public String toString() {
        return "Rols{" +
                "rolsId=" + rolsId +
                ", rolsName='" + rolsName + '\'' +
                '}';
    }
}
