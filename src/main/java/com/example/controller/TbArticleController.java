package com.example.controller;

import com.example.Utils.jsonUtil;
import com.example.bean.TbArticle;
import com.example.service.ArticleInterFace;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.example.Utils.jsonUtil.successResultJson;

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
    //引入json工具类
    private final JSONObject successResultJson = successResultJson();
    private final JSONObject failedResultJson = jsonUtil.failedResultJson();

    //增加文章首页
    @GetMapping("add")
    public String add(){
        return "article/article";
    }

    //增加日志首页
    @GetMapping("addarticle")
    public String addarticle(){
        return "article/add-article";
    }
    //增加文章操作
    @PostMapping("/addAtricle")
    @ResponseBody
    public String addAtricle(int userId,int typeId,String articleTitle,String articleContent,String articlesendTime,String articleCreate,String articleInfo,
                             int articleStatus,String articleFlag,String articleKeyword,int articleOpenness,String articleImg){
        TbArticle tbArticle = new TbArticle();
        tbArticle.setUserId(userId);
        tbArticle.setArticleType(typeId);
        tbArticle.setArticleTitle(articleTitle);
        tbArticle.setArticleContent(articleContent);
        tbArticle.setArticleSendTime(articlesendTime);
        tbArticle.setArticleCreate(articleCreate);
        tbArticle.setArticleInfo(articleInfo);
        tbArticle.setArticleStatus(articleStatus);
        tbArticle.setArticleFlag(articleFlag);
        tbArticle.setArticleKeyword(articleKeyword);
        tbArticle.setArticleOpenness(articleOpenness);
        tbArticle.setArticleImg(articleImg);
        logger.info("添加的文章信息为："+tbArticle);
        articleInterFace.addArticle(tbArticle);
        return "添加信息成功";
    }

    //展示文章信息
    @GetMapping("/show")
    public String show(int id, ModelMap map){
        List<TbArticle> tbArticle = articleInterFace.showArticle(id);
        successResultJson.put("msg","查询成功");
        successResultJson.put("data",tbArticle);
        map.addAttribute("articles",tbArticle);
        return "article/show";
    }

    //删除文章Id
    @PostMapping("/delete")
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

    //更新文章Get接口
    @GetMapping("/update")
    public String update(){
        return "/article/update.html";
    }

    //更新文章信息update
    @PostMapping("/updateArticle")
    @ResponseBody
    public String update(int primarykey,int articleTypeId,String articleTitle, String articleContent,String articleSendTime, String  articleCreate, String articleInfo) {
            //primarykey为要更新的文章主键，外键用户Id不能更改
            TbArticle Article = new TbArticle();
            Article.setArticleId(primarykey);
            Article.setArticleType(articleTypeId);
            Article.setArticleTitle(articleTitle);
            Article.setArticleContent(articleContent);
            Article.setArticleSendTime(articleSendTime);
            Article.setArticleCreate(articleCreate);
            Article.setArticleInfo(articleInfo);
            logger.info("更新文章信息为：" + Article);
            int flag =articleInterFace.updateArticle(Article);
            if(flag>0)
                return "更新成功";
            return "更新失败";
    }


}
