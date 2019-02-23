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
}
