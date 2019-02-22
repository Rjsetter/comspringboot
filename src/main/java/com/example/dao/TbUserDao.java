package com.example.dao;

import com.example.bean.TbUser;
import com.example.dao.baseDao.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface TbUserDao extends MyMapper<TbUser> {
    @Select("SELECT * FROM tb_user where user_name = #{username}")
    TbUser SelectUserByUsername(@Param("username") String username);
}
