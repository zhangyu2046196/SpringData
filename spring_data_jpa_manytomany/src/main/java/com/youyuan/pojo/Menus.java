package com.youyuan.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangyu
 * @version 1.0
 * @description 菜单实体信息
 * @date 2019/3/9 11:13
 */
@Entity
@Table(name = "t_menus")
public class Menus implements Serializable {
    private static final long serialVersionUID = 8513874377022654597L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="menu_id")
    private Integer menuId;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "menu_url")
    private String menuUrl;
    @Column(name = "faster_id")
    private Integer fasterId;
    @ManyToMany(mappedBy = "menusSet")
    private Set<Rols> rolsSet=new HashSet<Rols>();

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getFasterId() {
        return fasterId;
    }

    public void setFasterId(Integer fasterId) {
        this.fasterId = fasterId;
    }

    public Set<Rols> getRolsSet() {
        return rolsSet;
    }

    public void setRolsSet(Set<Rols> rolsSet) {
        this.rolsSet = rolsSet;
    }

    @Override
    public String toString() {
        return "Menus{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", fasterId=" + fasterId +
                '}';
    }
}
