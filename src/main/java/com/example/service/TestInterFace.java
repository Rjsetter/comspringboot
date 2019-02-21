package com.example.service;

import com.example.bean.User;
import com.example.bean.UserInfo;

import java.util.List;

/**
 * 业务接口层
 */
public interface TestInterFace {
    public int testInterFace();
    public UserInfo testUser();

    /**
     * 新增插入数据接口
     * @param username
     * @param password
     * @return
     */
    public int insertUser(String username, String password);

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
    public List<UserInfo> getAllUser();

}
