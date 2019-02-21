package com.example.service.impl;

import com.example.bean.User;
import com.example.bean.UserInfo;
import com.example.dao.UserDao;
import com.example.service.TestInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务接口层实现
 */
@Service
public class TestInterFaceImpl implements TestInterFace {
    //引入dao层接口
    @Autowired UserDao userDao;

    @Override
    public int testInterFace(){
        return 100;
    }

    @Override
    public UserInfo testUser(){
        return new UserInfo();
    }

    //新增接口实现
    @Override
    public int insertUser(String username,String password) {
        return userDao.insert(username,password);
    }

    //查询接口实现
    public UserInfo findUserByUserName(String username){return userDao.findByName(username); }

    //查询所有用户接口实现
    public List<UserInfo> getAllUser(){return userDao.getAllUser(); }
}
