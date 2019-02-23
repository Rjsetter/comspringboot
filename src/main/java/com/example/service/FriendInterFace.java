package com.example.service;

import com.example.bean.TbFriend;

/**
 * 业务层接口，好友模块
 */
public interface FriendInterFace {

    /**
     * 添加好友接口
     * @param tbFriend
     * @return
     */
    public int addFriend(TbFriend tbFriend);

    /**
     * 根据主键，好友id删除好友
     * @param friendId
     * @return
     */
    public int deleteFriend(int friendId);

    /**
     * 根据主键，friend_id查询好友信息
     * @param friendId
     * @return
     */
    public TbFriend findFriend(int friendId);

    /**
     * 根据主键更新好友信息
     * @param tbFriend
     * @return
     */
    public int updateFriend(TbFriend tbFriend);
}
