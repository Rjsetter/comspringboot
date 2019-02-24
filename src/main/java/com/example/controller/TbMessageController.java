package com.example.controller;

import com.example.bean.TbMessage;
import com.example.service.MessageInterFace;
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
 * Controller层实现，Message模块
 */
@Controller
@RequestMapping("message")
public class TbMessageController {
    //添加日志
    private final Logger logger = LoggerFactory.getLogger(TbMessageController.class);
    @Autowired
    MessageInterFace messageInterFace;

    //添加留言入口
    @GetMapping("add")
    public String add(){ return "message/add";}

    //添加留言接口
    @PostMapping("addMessage")
    @ResponseBody
    public String addMessage(int userId,String messageTitle,String messageAuthor,String messageContent,String messageTime){
        TbMessage tbMessage = new TbMessage();
        tbMessage.setUserId(userId);
        tbMessage.setMessageTitle(messageTitle);
        tbMessage.setMessageAuthor(messageAuthor);
        tbMessage.setMessageContent(messageContent);
        tbMessage.setMessageTime(messageTime);
        int flag =  messageInterFace.addMessage(tbMessage);
        if(flag>0){
            logger.info("添加留言信息为："+tbMessage);
            return "添加留言成功，留言信息如下："+tbMessage;
        }
        return "添加留言失败";
    }

    //删除留言接口
    @PostMapping("delete")
    @ResponseBody
    public String delete(int messageId){
        TbMessage message = messageInterFace.selectMessageByMessageId(messageId);
        int flag = messageInterFace.deleteMessageByMessageId(messageId);
        if(flag>0){
            logger.info("删除留言Id为"+messageId+"的留言，"+message);
            return "删除留言成功！";
        }
        return "删除留言失败";
    }

    //通过message_id查询单条留言接口
    @PostMapping("findOne")
    @ResponseBody
    public TbMessage findOne(int messageId){
        TbMessage tbMessage = messageInterFace.selectMessageByMessageId(messageId);
        if(tbMessage != null) {
            logger.info("查询到MessageId为" + messageId + "的留言为：" + tbMessage);
            return tbMessage;
        }
        return null;
    }

    //通过user_id查询该用户的所有留言信息
    @PostMapping("findAll")
    @ResponseBody
    public List<TbMessage> findAll(int userId){
        List<TbMessage> messages = messageInterFace.selectMessagesByUserId(userId);
        if(messages!=null){
            logger.info("查询到用户Id为"+userId+"的留言信息为："+messages);
            return messages;
        }
        return null;
    }
}
