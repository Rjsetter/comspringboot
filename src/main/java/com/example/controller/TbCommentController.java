package com.example.controller;

import com.example.Utils.jsonUtil;
import com.example.bean.TbComment;
import com.example.service.CommentInterFace;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

import static com.example.Utils.jsonUtil.String2JsonObject;
import static com.example.Utils.jsonUtil.successResultJson;

/**
 * Controller层实现，Comment模块
 */
@Controller
@RequestMapping("comment")
public class TbCommentController {
    //日志系统
    private final Logger logger = LoggerFactory.getLogger(TbCommentController.class);

    @Autowired
    CommentInterFace commentInterFace;
    //引入json工具类
    private final JSONObject successResultJson = successResultJson();
    private final JSONObject failedResultJson = jsonUtil.failedResultJson();


    //添加留言入口
    @GetMapping("add")
    public String add(){return "comment/add";}

    //添加留言接口
    @PostMapping("addComment")
    @ResponseBody
    public String addComment(int articleId,String reviewAuthor,String reviewContent){
        TbComment tbComment = new TbComment();
        tbComment.setCommentArticleId(articleId);
        tbComment.setReviewAuthor(reviewAuthor);
        tbComment.setReviewContent(reviewContent);
        int flag = commentInterFace.addComment(tbComment);
        if(flag>0){
            logger.info("添加留言信息为："+tbComment);
            successResultJson.put("data",tbComment);
            successResultJson.put("msg","添加留言成功！");
            return successResultJson.toString();
        }
        return failedResultJson.put("msg","添加信息留言失败！").toString();
    }

    //删除评论接口
    @PostMapping("delete")
    @ResponseBody
    public String delete(int commentId){
        TbComment comment = commentInterFace.findComment(commentId);
        int flag = commentInterFace.deleteComment(commentId);
        if(flag>0){
            logger.info("删除评论Id为"+commentId+"的留言，"+comment);
            successResultJson.put("msg","删除评论成功！");
            successResultJson.put("data",comment);
            return successResultJson.toString();
        }
        return  failedResultJson.put("msg","删除评论失败！").toString();
    }

    //通过comment_id查询单条评论接口
    @PostMapping(value = "findOne",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String findOne(int commentId){
        TbComment comment = commentInterFace.findComment(commentId);
        if(comment != null) {
            logger.info("查询到CommentId为" + commentId + "的留言为：" + comment);
            successResultJson.put("msg","查询成功！");
            successResultJson.put("data",comment);
            return successResultJson.toString();
        }
        return failedResultJson.put("msg","没有查询到信息").toString();
    }

    //通过article_id查询该文章的所有评论信息
    @PostMapping(value = "findAll")
    @ResponseBody()
    public String findAll(int articleId){
        TbComment tbComment = new TbComment();
        tbComment.setCommentArticleId(articleId);
        List<TbComment> messages =commentInterFace.findAllComment(tbComment);
        if(messages!=null){
            logger.info("查询到文章Id为"+articleId+"的留言信息为："+messages);
            successResultJson.put("msg","查询成功！");
            successResultJson.put("data",messages);
            return successResultJson.toString();
        }
        return failedResultJson.put("msg","没有查询到信息").toString();
    }

}
