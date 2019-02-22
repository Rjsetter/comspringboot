package com.example.service;

import com.example.bean.User;
import com.example.bean.UserInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 业务接口层
 */
public interface TestInterFace {
    public int testInterFace();
    public UserInfo testUser();

    /**
     * 新增插入用户接口
     * @param userInfo
     * @return
     */
    public int insertUser(UserInfo userInfo);

    /**
     * 新增查询接口，根据姓名查询
     * @param username
     * @return
     */
    public UserInfo findUserByUserName(String username);

    /**
     * 新增查询接口，查询所有用户
     * @return
     */
    public PageInfo<UserInfo> findAll(int pageNum, int pageSize);
    public List<UserInfo> getAllUser();
}
