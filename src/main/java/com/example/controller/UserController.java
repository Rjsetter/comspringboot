package com.example.controller;

import com.example.bean.User;
import com.example.bean.UserInfo;
import com.example.service.TestInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    //添加日志
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private TestInterFace testInterFace;

    @RequestMapping("/get")
    @ResponseBody
    UserInfo getUser() {
        return testInterFace.testUser();
    }

    //增加新的对外访问接口，插入功能
    @RequestMapping("/add/{username}&{password}")
    @ResponseBody
    String add(@PathVariable String username,@PathVariable String password) {
        //防止插入空信息
        if(username.length()==0 || password.length()==0){
            return "请输入正确信息";
        }
        testInterFace.insertUser(username,password);
        return "插入成功";
    }

    //增加新的对外访问接口，查询功能
    @RequestMapping("/getUserByName/{username}")
    @ResponseBody
    UserInfo getUserByName(@PathVariable String username){
        logger.info("正在查询姓名为"+username+"的用户！");
        UserInfo userInfo = testInterFace.findUserByUserName(username);
        return userInfo;
    }

    //增加新的对外访问接口，查询功能
    @RequestMapping("/getAll")
    @ResponseBody
    List<UserInfo> getAll(){
        List<UserInfo> users = testInterFace.getAllUser();
        return users;
    }
}


