package com.example.service;

import com.example.bean.TbArticle;
import com.example.bean.TbUser;

import java.util.List;

/**
 * 业务层接口，日志模块
 */
public interface ArticleInterFace {

    /**
     * 添加文章接口
     * @param tbArticle
     * @return
     */
    public int addArticle(TbArticle tbArticle);

    /**
     * 传入用户的Id，查询该用户下的所有文章
     * @param id
     * @return
     */
    public List<TbArticle> showArticle(int id);

    /**
     * 根据用户Id和文章Id删除文章
     * @param userId
     * @param articleId
     */
    public void deleteArticleByUserIdAndArticleId(int userId,int articleId);

    /**
     * 根据用户Id和文章Id查询文章信息
     * @param userId
     * @param articleId
     * @return
     */
    public TbArticle findArticleByUserIdAndArticleId(int userId,int articleId);

    /**
     * 更改文章
     * @param tbArticle
     */
    public int updateArticle(TbArticle tbArticle);
}
