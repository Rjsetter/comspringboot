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

    //添加信息主页面
    @GetMapping("add")
    public String add(){
        return "articleType/add";
    }

    //添加页面
    @PostMapping("addType")
    @ResponseBody
    public String add(String typeName,String typeInfo){
        TbArticleType tbArticleType = new TbArticleType();
        tbArticleType.setTypeName(typeName);
        tbArticleType.setTypeInfo(typeInfo);
        articleTypeInterFace.addArticleType(tbArticleType);
        return "添加分类成功";
    }
}
