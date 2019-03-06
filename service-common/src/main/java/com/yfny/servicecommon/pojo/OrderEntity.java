package com.yfny.servicecommon.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *  示例菜单对象
 * Created by zileShi on 2019/2/28.
 **/
@Table(name = "`order`")
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    @Column(name = "permission")
    private String permission;

    @Column(name = "function")
    private String function;

    public OrderEntity() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                ", function='" + function + '\'' +
                '}';
    }
}
