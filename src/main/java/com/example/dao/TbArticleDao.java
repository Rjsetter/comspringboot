package com.example.dao;

import com.example.bean.TbArticle;
import com.example.dao.baseDao.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface TbArticleDao extends MyMapper<TbArticle> {
    //根据用户ID搜索文章信息
    @Select("SELECT * FROM tb_article WHERE user_id=#{userId}")
    public List<TbArticle> selectArticleByUserId(@Param("userId") int userId);
}
