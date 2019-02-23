package com.example.controller;

import com.example.bean.TbFriend;
import com.example.service.FriendInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller层实现，Friend模块
 */
@Controller
@RequestMapping("friend")
public class TbFriendController {
    //日志系统
    private final Logger logger = LoggerFactory.getLogger(TbFriendController.class);
    @Autowired
    FriendInterFace friendInterFace;

    //添加好友入口
    @GetMapping("add")
    public String add(){
        return "friend/add";
    }
    //添加好友接口
    @PostMapping("addFriend")
    @ResponseBody
    public String addFriend(int userId,String friendName,String friendSex,String friendQq,String friendBlog){
        TbFriend Friend = new TbFriend();
        Friend.setUserId(userId);
        Friend.setFriendName(friendName);
        Friend.setFriendSex(friendSex);
        Friend.setFriendQq(friendQq);
        Friend.setFriendBlog(friendBlog);
        logger.info("添加好友信息如下："+Friend);
        int flag = friendInterFace.addFriend(Friend);
        if(flag>0)
            return "添加好友成功";
        return "添加好友失败";
    }

    //删除好友
    @PostMapping("delete")
    @ResponseBody
    public String delete(int friendId){
        TbFriend tbFriend = friendInterFace.findFriend(friendId);
        int flag =  friendInterFace.deleteFriend(friendId);
        if(flag>0) {
            logger.info("删除的好友信息为：" + tbFriend);
            return "成功删除";
        }
        return "删除失败";
    }

    //根据friend查询好友
    @PostMapping("find")
    @ResponseBody
    public String find(int friendId){
        TbFriend tbFriend = friendInterFace.findFriend(friendId);
        logger.info("查询到好友信息为："+tbFriend);
        if(tbFriend!=null)
            return tbFriend.toString();
        return "没有好友信息！";
    }
    //更新好友入口
    @GetMapping("update")
    public String update(){
        return "friend/update";
    }
    //更新好友接口
    @PostMapping("updateFriend")
    @ResponseBody
    public String updateFriend(int friendId,int userId,String friendName,String friendSex,String friendQq,String friendBlog){
        TbFriend tbFriend = new TbFriend();
        tbFriend.setFriendId(friendId);
        tbFriend.setUserId(userId);
        tbFriend.setFriendName(friendName);
        tbFriend.setFriendSex(friendSex);
        tbFriend.setFriendQq(friendQq);
        tbFriend.setFriendBlog(friendBlog);
        int flag = friendInterFace.updateFriend(tbFriend);
        if(flag>0){
            logger.info("更新好友信息为："+tbFriend);
            return tbFriend.toString();
        }
        return "更新用户失败！";
    }
}
