package com.example.controller;

import com.example.bean.TbComment;
import com.example.service.CommentInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
            return "添加留言信息为："+tbComment;
        }
        return "添加信息留言失败！";
    }

    //删除评论接口
    @PostMapping("delete")
    @ResponseBody
    public String delete(int commentId){
        TbComment comment = commentInterFace.findComment(commentId);
        int flag = commentInterFace.deleteComment(commentId);
        if(flag>0){
            logger.info("删除评论Id为"+commentId+"的留言，"+comment);
            return "删除评论成功！";
        }
        return "删除评论失败";
    }

    //通过comment_id查询单条评论接口
    @PostMapping("findOne")
    @ResponseBody
    public TbComment findOne(int commentId){
        TbComment comment = commentInterFace.findComment(commentId);
        if(comment != null) {
            logger.info("查询到CommentId为" + commentId + "的留言为：" + comment);
            return comment;
        }
        return null;
    }

    //通过article_id查询该文章的所有评论信息
    @PostMapping("findAll")
    @ResponseBody
    public List<TbComment> findAll(int articleId){
        TbComment tbComment = new TbComment();
        tbComment.setCommentArticleId(articleId);
        List<TbComment> messages =commentInterFace.findAllComment(tbComment);
        if(messages!=null){
            logger.info("查询到文章Id为"+articleId+"的留言信息为："+messages);
            return messages;
        }
        return null;
    }

}
