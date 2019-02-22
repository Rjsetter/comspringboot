package com.example.dao;

import com.example.bean.TbComment;
import com.example.dao.baseDao.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbCommentDao extends MyMapper<TbComment> {
}
