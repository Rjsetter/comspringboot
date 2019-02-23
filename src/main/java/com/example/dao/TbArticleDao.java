package com.example.dao;

import com.example.bean.TbArticle;
import com.example.dao.baseDao.MyMapper;
import org.apache.ibatis.annotations.Delete;
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

    //根据用户Id和文章Id查找文章
    @Select("Select * from tb_article where user_id=#{userId} AND article_id=#{articleId} ")
    public TbArticle findArticleByUserIdAndArticleId(@Param("userId") int userId,@Param("articleId") int articleId);

    //根据用户Id和文章Id删除文章
    @Delete("DELETE FROM tb_article WHERE user_id=#{userId} AND article_id=#{articleId}")
    public void deleteArticleByUserIdAndArticleId(@Param("userId") int userId,@Param("articleId") int articleId);

}
