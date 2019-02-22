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
}
