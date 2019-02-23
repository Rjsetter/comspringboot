package com.example.service.impl;

import com.example.bean.TbArticle;
import com.example.dao.TbArticleDao;
import com.example.dao.TbUserDao;
import com.example.service.ArticleInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务接口层实现，Article模块
 * @author RJSETTER
 * @Date 2019/2/22
 */
@Service
public class ArticleInterFaceImpl implements ArticleInterFace {
    //增加日志
    private final Logger logger = LoggerFactory.getLogger(ArticleInterFaceImpl.class);
    //引入dao层接口
    @Autowired
    TbArticleDao tbArticleDao;

    @Override
    public int addArticle(TbArticle tbArticle){
        return tbArticleDao.insert(tbArticle);
    }
}
