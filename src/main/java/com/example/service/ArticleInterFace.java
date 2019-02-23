package com.example.service;

import com.example.bean.TbArticle;

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
}
