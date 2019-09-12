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

    //@ManyToMany代表多对多关系，@JoinTable代表两个多对多关系实体的中间表，存储关联外键,joinColumns代表配置到中间表中的当前
    //实体的主键,inverseJoinColumns代表对应实体配置到中间表的主键
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "t_rols_menu",joinColumns = @JoinColumn(name = "rols_id"),inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private Set<Menus> menusSet=new HashSet<Menus>();

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

    public Set<Menus> getMenusSet() {
        return menusSet;
    }

    public void setMenusSet(Set<Menus> menusSet) {
        this.menusSet = menusSet;
    }

    @Override
    public String toString() {
        return "Rols{" +
                "rolsId=" + rolsId +
                ", rolsName='" + rolsName + '\'' +
                '}';
    }
}
