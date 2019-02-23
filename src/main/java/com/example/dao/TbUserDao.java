package com.example.dao;

import com.example.bean.TbUser;
import com.example.dao.baseDao.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TbUserDao extends MyMapper<TbUser> {
    @Select("SELECT * FROM tb_user where user_name = #{username}")
    TbUser SelectUserByUsername(@Param("username") String username);

    //验证是否已经登录
    @Select("SELECT * FROM tb_user where user_name=#{username} AND user_password = #{password}")
    public List<TbUser> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
