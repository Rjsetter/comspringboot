package com.example.service.impl;

import com.example.bean.TbUser;
import com.example.dao.TbUserDao;
import com.example.service.UserInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务接口层实现，user模块
 * @author RJSETTER
 * @Date 2019/2/22
 */

@Service
public class UsrInterFaceImpl implements UserInterFace {
    //引入dao层接口
    @Autowired
    TbUserDao tbUserDao;

    @Override
    public int insertUser(TbUser tbUser){return tbUserDao.insert(tbUser);}

    @Override
    public boolean login(String username,String password){
        TbUser tbUser = new TbUser();
        tbUser = tbUserDao.SelectUserByUsername(username);
        //这里判断用 == 号会判断失败，应该用equals()
        //==相当于判断对象是否指向同一内存
        if(tbUser.getUserName().equals(username) && tbUser.getUserPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
