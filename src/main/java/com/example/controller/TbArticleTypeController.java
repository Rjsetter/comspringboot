package com.example.controller;

import com.example.bean.TbArticleType;
import com.example.service.ArticleTypeInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller层实现，ArticleType模块
 */
@Controller
@RequestMapping("articleType")
public class TbArticleTypeController {
    //日志系统
    private final Logger logger = LoggerFactory.getLogger(TbArticleTypeController.class);
    @Autowired
    private ArticleTypeInterFace articleTypeInterFace;

    //添加信息入口
    @GetMapping("add")
    public String add(){
        return "articleType/add";
    }

    //添加页面
    @PostMapping("addType")
    public String add(String typeName,String typeInfo){
        TbArticleType tbArticleType = new TbArticleType();
        tbArticleType.setTypeName(typeName);
        tbArticleType.setTypeInfo(typeInfo);
        articleTypeInterFace.addArticleType(tbArticleType);
        return "articleType/success";
    }

    //更改文章入口
    @GetMapping("update")
    public String update(){
        return "articleType/update.html";
    }
    //更改文章类型
    @PostMapping("updateType")
    @ResponseBody
    public String updateType(int typeId, String typeName, String typeInfo){
        TbArticleType tbArticleType = new TbArticleType();
        tbArticleType.setTypeId(typeId);
        tbArticleType.setTypeName(typeName);
        tbArticleType.setTypeInfo(typeInfo);
        logger.info("更新文章类型为："+tbArticleType);
        int flag = articleTypeInterFace.updateArticleType(tbArticleType);
        if(flag>0)
            return "update.html success";
        return "update.html faliled";
    }
    //删除文章类型
    @PostMapping("deleteType")
    @ResponseBody
    public String delete(int articleTypeId){
        logger.info("删除的文章类型为："+articleTypeInterFace.selectOne(articleTypeId));
        int flag = articleTypeInterFace.deleteArticleType(articleTypeId);
        if(flag>0)
            return "删除成功";
        return "删除失败";
    }

    //查询文章类型信息
    @PostMapping("selectOneType")
    @ResponseBody
    public String selectOne(int articleTypeId){
        if(articleTypeInterFace.selectOne(articleTypeId)!=null)
            return articleTypeInterFace.selectOne(articleTypeId).toString();
        return "数据库中没有改信息";
    }
}
