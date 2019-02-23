package com.example.service.impl;

import com.example.bean.TbFriend;
import com.example.dao.TbFriendDao;
import com.example.service.FriendInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务接口层实现，friend模块
 * @author RJSETTER
 * @Date 2019/2/22
 */
@Service
public class FriendInterFaceImpl implements FriendInterFace {
    //增加日志
    private final Logger logger = LoggerFactory.getLogger(FriendInterFaceImpl.class);
    //引入dao层接口
    @Autowired
    TbFriendDao tbFriendDao;

    @Override
    public int addFriend(TbFriend tbFriend){
        logger.info("插入的好友信息为："+tbFriend.toString());
        return tbFriendDao.insert(tbFriend);
    }

    @Override
    public int deleteFriend(int friendId){
        return tbFriendDao.deleteByPrimaryKey(friendId);
    }
    @Override
    public TbFriend findFriend(int friendId){
        return tbFriendDao.selectByPrimaryKey(friendId);
    }
    public int updateFriend(TbFriend tbFriend){
        return tbFriendDao.updateByPrimaryKeySelective(tbFriend);
    }
}
