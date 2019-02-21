package com.example.controller;

import com.example.bean.User;
import com.example.bean.UserInfo;
import com.example.service.TestInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestBootController {
    //增加日志
    private final Logger  logger = LoggerFactory.getLogger(TestBootController.class);
    @Autowired
    private TestInterFace testInterFace;

    @RequestMapping("/num")
    @ResponseBody
    int home() {
        logger.info("测试日志系统！");
        int i = testInterFace.testInterFace();
        return i;
    }

    @RequestMapping("/get")
    @ResponseBody
    UserInfo getUser() {
        //日志系统
        logger.info("获取用户信息！");
        System.out.println(testInterFace.testUser().getUsername());
        return testInterFace.testUser();
    }
}

