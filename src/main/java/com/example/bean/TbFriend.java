package com.example.bean;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 好友类实体类，对应数据库tb_friend
 * @author RJSETTER
 * @Date 2019/2/22
 */@Table(name="tb_friend")
public class TbFriend {
     @Column(name="friend_id")
    private Integer friendId;
     @Column(name="user_id")
    private Integer userId;
     @Column(name="friend_name")
    private String friendName;
     @Column(name="friend_sex")
    private String friendSex;
     @Column(name="friend_qq")
    private String friendQq;
     @Column(name="friend_blog")
    private String friendBlog;

    @Override
    public String toString(){
        return "friend{" +
                "friendId='" + friendId + '\'' +
                ", userId='" + userId + '\'' +
                ", friendName='" + friendName + '\'' +
                ", friendSex='" + friendSex + '\'' +
                ", friendQq='" + friendQq + '\'' +
                ", friendBlog='" + friendBlog + '\'' +
                '}';
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getFriendSex() {
        return friendSex;
    }

    public void setFriendSex(String friendSex) {
        this.friendSex = friendSex;
    }

    public String getFriendQq() {
        return friendQq;
    }

    public void setFriendQq(String friendQq) {
        this.friendQq = friendQq;
    }

    public String getFriendBlog() {
        return friendBlog;
    }

    public void setFriendBlog(String friendBlog) {
        this.friendBlog = friendBlog;
    }
}
