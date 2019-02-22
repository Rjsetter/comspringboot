package com.example.bean;

/**
 * 好友类实体类，对应数据库tb_friend
 * @author RJSETTER
 * @Date 2019/2/22
 */
public class TbFriend {
    private Integer friendId;
    private Integer userId;
    private String friendName;
    private String friendSex;
    private String friendQq;
    private String friendBlog;

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
