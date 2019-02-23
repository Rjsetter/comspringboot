package com.example.controller;

import com.example.bean.TbArticle;
import com.example.bean.TbUser;
import com.example.service.ArticleInterFace;
import com.example.service.UserInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    //增加文章操作
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

    //展示文章信息
    @GetMapping("show")
    @ResponseBody
    public List<TbArticle> show(int id){
        List<TbArticle> tbArticle = articleInterFace.showArticle(id);
        return tbArticle;
    }
    //删除文章Id
    @PostMapping("delete")
    @ResponseBody
    public String delete(int userId,int articleId){
        TbArticle tbArticle = articleInterFace.findArticleByUserIdAndArticleId(userId,articleId);
        if(tbArticle!=null){
            logger.info("该用户的文章如下："+tbArticle+"\n"+"删除的文章Id为："+articleId);
            articleInterFace.deleteArticleByUserIdAndArticleId(userId,articleId);
            return "删除文章成功!";
        }else{
            logger.info("删除错误，请输入正确的信息！");
            return "删除错误，请输入正确的信息！";
        }

    }
}
