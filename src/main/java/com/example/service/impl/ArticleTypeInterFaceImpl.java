package com.example.service.impl;
import com.example.bean.TbArticleType;
import com.example.dao.TbArticleTypeDao;
import com.example.service.ArticleTypeInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务接口层实现，ArticleType模块
 * @author RJSETTER
 * @Date 2019/2/22
 */
@Service
public class ArticleTypeInterFaceImpl implements ArticleTypeInterFace {
    //增加日志
    private final Logger logger = LoggerFactory.getLogger(ArticleTypeInterFaceImpl.class);

    @Autowired
    TbArticleTypeDao tbArticleTypeDao;

    @Override
    public int addArticleType(TbArticleType tbArticleType){
        logger.info("插入的分类信息为："+tbArticleType.toString());
        return tbArticleTypeDao.insert(tbArticleType);
    }
}
