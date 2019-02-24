package com.example.service;

import com.example.bean.TbComment;

import java.util.List;

/**
 * 业务层接口，评论模块
 *commentArticle_id  文章ID
 * review_author 评论者
 * review_content 评论内容
 */
public interface CommentInterFace {

    /**
     * 添加评论
     * @param tbComment
     * @return
     */
    public int addComment(TbComment tbComment);

    /****
     * 根据留言表主键comment_id删除评论信息
     * @param commentId
     * @return
     */
    public int deleteComment(int commentId);

    /**
     * 根据留言表主键comment_id查询评论信息
     * @param commentId
     * @return
     */
    public TbComment findComment(int commentId);

    /**
     * 根据文章article_id查询,文章的所有信息评论信息
     * @param tbComment
     * @return
     */
    public List<TbComment> findAllComment(TbComment tbComment);
}
