package com.example.dao;

import com.example.bean.TbArticle;
import com.example.dao.baseDao.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbArticleDao extends MyMapper<TbArticle> {
}
