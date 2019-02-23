package com.example.service.impl;

import com.example.bean.TbArticle;
import com.example.bean.TbUser;
import com.example.dao.TbArticleDao;
import com.example.dao.TbUserDao;
import com.example.service.ArticleInterFace;
import org.apache.ibatis.annotations.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<TbArticle> showArticle(int id){
        //通过用户的Id来查询文章信息
        return tbArticleDao.selectArticleByUserId(id);
    }

    @Override
    public void deleteArticleByUserIdAndArticleId(int userId,int articleId){
        //根据用户Id和文章Id删除文章
        tbArticleDao.deleteArticleByUserIdAndArticleId(userId,articleId);
    }
    @Override
    public TbArticle findArticleByUserIdAndArticleId(int userId,int articleId){
        return tbArticleDao.findArticleByUserIdAndArticleId(userId,articleId);
    }

    @Override
    public int updateArticle(TbArticle tbArticle){
        //返回值为受影响的行数，>0代表更新成功
        return tbArticleDao.updateByPrimaryKeySelective(tbArticle);
    }
}
