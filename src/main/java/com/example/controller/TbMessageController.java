package com.example.controller;

import com.example.service.MessageInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller层实现，Message模块
 */
@Controller
@RequestMapping("message")
public class TbMessageController {
    //添加日志
    private final Logger logger = LoggerFactory.getLogger(TbMessageController.class);
    @Autowired
    MessageInterFace messageInterFace;
}
