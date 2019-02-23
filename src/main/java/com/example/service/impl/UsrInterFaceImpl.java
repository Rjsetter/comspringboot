package com.example.service.impl;

import com.example.bean.TbUser;
import com.example.controller.TbUserController;
import com.example.dao.TbUserDao;
import com.example.service.UserInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * 业务接口层实现，user模块
 * @author RJSETTER
 * @Date 2019/2/22
 */

@Service
public class UsrInterFaceImpl implements UserInterFace {
    //增加日志
    private final Logger logger = LoggerFactory.getLogger(UsrInterFaceImpl.class);
    //引入dao层接口
    @Autowired
    TbUserDao tbUserDao;

    @Override
    public int insertUser(TbUser tbUser){return tbUserDao.insert(tbUser);}

    @Override
    public boolean login(String username, String password){
        TbUser tbUser = new TbUser();
        tbUser = tbUserDao.SelectUserByUsername(username);
        logger.info(tbUser.toString());
        //这里判断用 == 号会判断失败，应该用equals()
        //==相当于判断对象是否指向同一内存
        if(tbUser.getUserName().equals(username) && tbUser.getUserPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void update(TbUser tbUser){
        tbUserDao.updateByExampleSelective(tbUser, tbUser.getUserId());
    }

    @Override
    public TbUser selectOneByUserName(String username){
        return tbUserDao.SelectUserByUsername(username);
    }

    @Override
    public List<TbUser> getAllUser(){
        return tbUserDao.selectAll();
    }

    //验证登录
    public boolean verifyLogin(TbUser user){
        List<TbUser> userList = tbUserDao.findByUsernameAndPassword(user.getUserName(), user.getUserPassword());
        logger.info("验证登录查询："+userList.size()+"-->"+user.toString());
        return userList.size()>0;
    }
}
