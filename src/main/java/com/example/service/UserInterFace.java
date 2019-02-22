package com.example.service;

import com.example.bean.TbUser;

import java.util.List;

/**
 * 业务层接口，user模块的业务
 */
public interface UserInterFace {
    /**
     * 新增加博客用户接口
     * @param tbUser
     * @return
     */
    public int insertUser(TbUser tbUser);

    /**
     * 登录接口
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username,String password);

    /**
     * 更新用户
     * @param tbUser
     * @return
     */
    public void update(TbUser tbUser);

    /**
     * 根据姓名搜查用户
     * @param username
     * @return
     */
    public TbUser selectOneByUserName(String username);

    /**
     * 查询所有用户
     * @return
     */
    public List<TbUser> getAllUser();
}
