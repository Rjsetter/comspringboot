package com.example.service;

import com.example.bean.TbArticleType;

/***
 * 业务层接口，文章类型模块
 */
public interface ArticleTypeInterFace {
    /**
     * 添加文章类型接口
     * @param tbArticleType
     * @return
     */
    public int addArticleType(TbArticleType tbArticleType);
}
