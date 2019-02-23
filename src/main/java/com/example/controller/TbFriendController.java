package com.example.controller;

import com.example.service.FriendInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller层实现，Friend模块
 */
@Controller
@RequestMapping("friend")
public class TbFriendController {
    //日志系统
    private final Logger logger = LoggerFactory.getLogger(TbFriendController.class);
    @Autowired
    FriendInterFace friendInterFace;

}
