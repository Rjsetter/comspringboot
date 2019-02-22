package com.example.service;

import com.example.bean.TbUser;

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
}
