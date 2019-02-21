package com.example.dao;

import com.example.bean.User;
import com.example.bean.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("SELECT * FROM USERINFO WHERE username = #{username}")
    UserInfo findByName(@Param("username") String username);

    @Insert("INSERT INTO USERINFO(username, password) VALUES(#{username}, #{password})")
    int insert(@Param("username") String name, @Param("password") String password);

    @Select("SELECT * FROM USERINFO")
    List<UserInfo> getAllUser();
}

