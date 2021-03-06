package com.example.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 文章实体类，对应数据库tb_article
 * @author RJSETTER
 * @Date 2019/2/21
 */
@Table(name="tb_article")
public class TbArticle {
    //映射的实体类没有标明主键，在实体类的主键上标明（使用@id）
    @Column(name="article_id")
    @Id
    private Integer articleId;
    @Column(name="user_id")
    private Integer userId;
    @Column(name="article_type")
    private Integer articleType;
    @Column(name="article_title")
    private String articleTitle;
    @Column(name="article_content")
    private String articleContent;
    @Column(name="article_sendTime")
    private String articleSendTime;
    @Column(name="article_create")
    private String articleCreate;
    @Column(name="article_info")
    private String articleInfo;
    @Column(name = "article_status")
    private Integer articleStatus;
    @Column(name = "article_flag")
    private String articleFlag;
    @Column(name = "article_keyword")
    private String articleKeyword;
    @Column(name="article_openness")
    private Integer articleOpenness;
    @Column(name = "article_img")
    private String articleImg;

    public String getArticleImg() {
        return articleImg;
    }

    public void setArticleImg(String articleImg) {
        this.articleImg = articleImg;
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    public String getArticleFlag() {
        return articleFlag;
    }

    public void setArticleFlag(String articleFlag) {
        this.articleFlag = articleFlag;
    }

    public String getArticleKeyword() {
        return articleKeyword;
    }

    public void setArticleKeyword(String articleKeyword) {
        this.articleKeyword = articleKeyword;
    }

    public Integer getArticleOpenness() {
        return articleOpenness;
    }

    public void setArticleOpenness(Integer articleOpenness) {
        this.articleOpenness = articleOpenness;
    }

    public String getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(String articleInfo) {
        this.articleInfo = articleInfo;
    }


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

    @Override
    public String toString(){
        return "{" + "articleId:'" + articleId + '\'' +
                ", userId:'" + userId + '\'' +
                ", articleType:'" + articleType + '\'' +
                ", articleTitle:'" + articleTitle + '\'' +
                ", articleContent:'" + articleContent + '\'' +
                ", articleSendTime:'" + articleSendTime + '\'' +
                ", articleCreate:'" + articleCreate + '\'' +
                ", articleInfo:'" + articleInfo + '\'' +
                ", articleStatus:'" + articleStatus + '\'' +
                ", articleFlag:'" + articleFlag + '\'' +
                ", articleKeyword:'" + articleKeyword + '\'' +
                ", articleOpenness:'" + articleOpenness + '\'' +
                ", articleImg:'" + articleImg + '\'' +
                '}';
    }
}
