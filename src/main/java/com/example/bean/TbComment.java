package com.example.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 评论类实体类，对应数据库tb_comment
 * @author RJSETTER
 * @Date 2019/2/22
 */
@Table(name="tb_comment")
public class TbComment {
    @Column(name="comment_id")
    @Id
    private Integer commentId;
    @Column(name="commentArticle_id")
    private Integer commentArticleId;
    @Column(name="review_author")
    private String reviewAuthor;
    @Column(name="review_content")
    private String reviewContent;

    @Override
    public String toString(){
        return "{" +
                "commentId:'" + commentId + '\'' +
                ", commentArticleId:'" + commentArticleId + '\'' +
                ", reviewAuthor:'" + reviewAuthor + '\'' +
                ", reviewContent:'" + reviewContent + '\'' +
                '}';
    }

    public Integer getCommentId() { return commentId; }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentArticleId() {
        return commentArticleId;
    }

    public void setCommentArticleId(Integer commentArticleId) {
        this.commentArticleId = commentArticleId;
    }

    public String getReviewAuthor() {
        return reviewAuthor;
    }

    public void setReviewAuthor(String reviewAuthor) {
        this.reviewAuthor = reviewAuthor;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }
}
