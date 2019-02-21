package com.example.bean;
/**
 * 文章实体类，对应数据库tb_article
 * @author RJSETTER
 * @Date 2019/2/21
 */
public class TbArticle {
    private Integer articleId;
    private Integer userId;
    private Integer articleType;
    private String articleTitle;
    private String articleContent;
    private String articleSendTime;
    private String articleCreate;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleSendTime() {
        return articleSendTime;
    }

    public void setArticleSendTime(String articleSendTime) {
        this.articleSendTime = articleSendTime;
    }

    public String getArticleCreate() {
        return articleCreate;
    }

    public void setArticleCreate(String articleCreate) {
        this.articleCreate = articleCreate;
    }
}
