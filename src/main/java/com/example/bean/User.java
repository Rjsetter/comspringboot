package com.example.bean;

import java.util.Date;

public class User {
   private String Name;

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    private Integer Age;
   private String Password;



    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    private String Desc;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    private Date Birthday;
}
