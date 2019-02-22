package com.example.dao;

import com.example.bean.TbFriend;
import com.example.dao.baseDao.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbFriendDao extends MyMapper<TbFriend> {
}
