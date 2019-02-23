package com.example.controller;

import com.example.bean.TbArticle;
import com.example.service.ArticleInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Controller层实现，Article模块
 */
@Controller
@RequestMapping("article")
public class TbArticleController {
    //增加日志
    private Logger logger = LoggerFactory.getLogger(TbArticleController.class);
    //引入dao层接口
    @Autowired
    ArticleInterFace articleInterFace;

    //增加日志首页
    @GetMapping("add")
    public String add(){
        return "article/add";
    }

    @PostMapping("/addAtricle")
    @ResponseBody
    public String addAtricle(int userId,int typeId,String articleTitle,String articleContent,String articlesendTime,String articleCreate,String articleInfo ){
        TbArticle tbArticle = new TbArticle();
        tbArticle.setUserId(userId);
        tbArticle.setArticleType(typeId);
        tbArticle.setArticleTitle(articleTitle);
        tbArticle.setArticleContent(articleContent);
        tbArticle.setArticleSendTime(articlesendTime);
        tbArticle.setArticleCreate(articleCreate);
        tbArticle.setArticleInfo(articleInfo);
        logger.info("添加的文章信息为："+tbArticle);
        articleInterFace.addArticle(tbArticle);
        return "添加信息成功";
    }

}
