package com.yfny.servicecommon.pojo;

import com.yfny.servicecommon.enums.UserSexEnum;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * 示例用户对象
 * Created by jisongZhou on 2019/2/19.
 **/
@Table(name = "user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id//不可缺，要不然使用通用Mapper工具的更新方法不生效
    private Long id;

    @Column(name = "user_name")//对应数据库的字段
    private String userName;

    @Column(name = "pass_word")
    private String passWord;

    @Column(name = "user_sex")
    private UserSexEnum userSex;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "permission")
    private String permission;

    private DetailsEntity detailsEntity;//实例用户详细信息，一对一关系

    private List<CarEntity> carEntities;//实例用户拥有车辆详细信息，一对多关系

    @Transient//这样在映射数据表和对象关系时候就不会报在表中不存在该字段的问题
    private String function;//权限功能，这个根据微服务service-tips来获取值渲染

    public UserEntity() {
        super();
    }

    public UserEntity(String userName, String passWord, UserSexEnum userSex) {
        super();
        this.passWord = passWord;
        this.userName = userName;
        this.userSex = userSex;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public UserSexEnum getUserSex() {
        return userSex;
    }

    public void setUserSex(UserSexEnum userSex) {
        this.userSex = userSex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public DetailsEntity getDetailsEntity() {
        return detailsEntity;
    }

    public void setDetailsEntity(DetailsEntity detailsEntity) {
        this.detailsEntity = detailsEntity;
    }

    public List<CarEntity> getCarEntities() {
        return carEntities;
    }

    public void setCarEntities(List<CarEntity> carEntities) {
        this.carEntities = carEntities;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userSex=" + userSex.name() +
                ", nickName='" + nickName + '\'' +
                ", permission='" + permission + '\'' +
                ", detailsEntity=" + detailsEntity +
                ", carEntities=" + carEntities +
                ", function='" + function + '\'' +
                '}';
    }
}
