package com.example.bean;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 留言表实体类，对应数据库tb_message
 * @author RJSETTER
 * @Date 2019/2/22
 */
@Table(name="tb_message")
public class TbMessage {
    @Column(name="user_id")
    private Integer userId;
    @Column(name="message_title")
    private String messageTitle;
    @Column(name="message_author")
    private String messageAuthor;
    @Column(name="message_content")
    private String messageContent;
    @Column(name="message_time")
    private String messageTime;
    @Column(name="message_id")
    private Integer messageId;

    @Override
    public String toString(){
        return "message{" +
                "messageId='" + messageId + '\'' +
                ", userId='" + userId + '\'' +
                ", messageTitle='" + messageTitle + '\'' +
                ", messageAuthor='" + messageAuthor + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageTime='" + messageTime + '\'' +
                '}';
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageAuthor() {
        return messageAuthor;
    }

    public void setMessageAuthor(String messageAuthor) {
        this.messageAuthor = messageAuthor;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }
}
