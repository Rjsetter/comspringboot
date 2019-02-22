package com.example.dao;

import com.example.bean.TbMessage;
import com.example.dao.baseDao.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbMessageDao extends MyMapper<TbMessage> {
}
