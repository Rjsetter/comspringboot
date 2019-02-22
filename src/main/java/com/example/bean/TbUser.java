package com.example.bean;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 用户实体类，对应数据库tb_user
 * @author RJSETTER
 * @Date 2019/2/21
 */
//增加注解声明表名
@Table(name = "tb_user")
public class TbUser {
    //增加注解声明字段名
    @Column(name="user_id")
    private Integer userId;
    @Column(name ="user_name")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_sex")
    private String userSex;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_qq")
    private String userQq;

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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }
}
