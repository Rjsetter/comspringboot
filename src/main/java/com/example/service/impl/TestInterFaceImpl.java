package com.example.service.impl;

import com.example.bean.User;
import com.example.bean.UserInfo;
import com.example.dao.UserDao;
import com.example.service.TestInterFace;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public int insertUser(UserInfo userInfo){
        return userDao.insert(userInfo);
    }

    @Override
    public PageInfo<UserInfo> findAll(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);//改写语句实现分页查询
        List<UserInfo> all = userDao.selectAll();
        PageInfo<UserInfo> info = new PageInfo<UserInfo>(all);
        return info;
    }

    @Override
    public  UserInfo findUserByUserName(String username){
        return userDao.findByName(username);
    };

    //查询所有用户接口实现
    @Override
    public List<UserInfo> getAllUser(){return userDao.selectAll(); }
}

