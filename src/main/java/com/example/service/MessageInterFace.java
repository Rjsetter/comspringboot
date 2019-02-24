package com.example.service;

import com.example.bean.TbMessage;

import java.util.List;

/**
 * 业务层接口，留言模块
 */
public interface MessageInterFace {

    /**
     * 添加留言信息
     * @param tbMessage
     * @return
     */
    public int addMessage(TbMessage tbMessage);

    /**
     * 通过主键message_id删除留言信息
     * @param messageId
     * return
     */
    public int deleteMessageByMessageId(int messageId);

    /**
     * 根据message_id查询单条留言信息
     * @param messageId
     * @return
     */
    public TbMessage selectMessageByMessageId(int messageId);

    /**
     * 根据用户Id查询该用户下的所有信息
     * @param userId
     * @return
     */
    public List<TbMessage> selectMessagesByUserId(int userId);
}
