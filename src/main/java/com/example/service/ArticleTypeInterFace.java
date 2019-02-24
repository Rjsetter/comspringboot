package com.example.service;

import com.example.bean.TbArticleType;

/***
 * 业务层接口，文章类型模块
 * 日志类型管理：对日志类型进行增、删、改、查。
 */
public interface ArticleTypeInterFace {
    /**
     * 添加文章类型接口
     * @param tbArticleType
     * @return
     */
    public int addArticleType(TbArticleType tbArticleType);

    /**
     * 根据主键更新文章类型
     * @param tbArticleType
     * @return
     */
    public int updateArticleType(TbArticleType tbArticleType);

    /**
     * 根据主键删除文章类型
     * @param articleTypeId
     * @return
     */
    public int deleteArticleType(int articleTypeId);

    /**
     * 根据主键查询文章信息
     * @param articleTypeId
     * @return
     */
    public TbArticleType selectOne(int articleTypeId);
}
