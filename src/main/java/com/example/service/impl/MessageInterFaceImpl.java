package com.example.service.impl;

import com.example.bean.TbMessage;
import com.example.dao.TbMessageDao;
import com.example.service.MessageInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务接口层实现，message模块
 * @author RJSETTER
 * @Date 2019/2/22
 */
@Service
public class MessageInterFaceImpl implements MessageInterFace {
    //添加日志系统
    private final Logger logger = LoggerFactory.getLogger(MessageInterFaceImpl.class);
    //引入dao层接口
    @Autowired
    TbMessageDao tbMessageDao;

    @Override
    public int addMessage(TbMessage tbMessage){
        return tbMessageDao.insert(tbMessage);
    }

    @Override
    public int deleteMessageByMessageId(int messageId){
        return tbMessageDao.deleteByPrimaryKey(messageId);
    }

    @Override
    public TbMessage selectMessageByMessageId(int messageId){
        return tbMessageDao.selectByPrimaryKey(messageId);
    }

    @Override
    public List<TbMessage> selectMessagesByUserId(int userId){
        TbMessage tbMessage = new TbMessage();
        tbMessage.setUserId(userId);
        return tbMessageDao.select(tbMessage);
    }
}
