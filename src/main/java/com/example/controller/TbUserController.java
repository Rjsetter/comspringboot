package com.example.controller;


import com.example.bean.TbUser;
import com.example.service.UserInterFace;
import org.omg.Dynamic.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Controller层实现，User模块
 */
@Controller
@RequestMapping("tbuser")
public class TbUserController {
    //添加日志
    private final Logger logger = LoggerFactory.getLogger(TbUserController.class);
    @Autowired
    private UserInterFace userInterFace;

    //对外访问接口，增加用户接口
    @GetMapping("add")
    @ResponseBody
    public String add(String userName,String userPassword,String userSex,String userEmail,String userQq){
        TbUser tbUser = new TbUser();
        tbUser.setUserName(userName);
        tbUser.setUserPassword(userPassword);
        tbUser.setUserSex(userSex);
        tbUser.setUserEmail(userEmail);
        tbUser.setUserQq(userQq);
        userInterFace.insertUser(tbUser);
        return "插入成功";
    }

}
