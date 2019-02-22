package com.example.dao;

import com.example.bean.TbUser;
import com.example.dao.baseDao.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbUserDao extends MyMapper<TbUser> {

}
