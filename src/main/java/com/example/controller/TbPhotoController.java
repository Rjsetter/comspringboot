package com.example.controller;

import com.example.service.PhotoInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller层实现，Photo模块
 */
@Controller
@RequestMapping("photo")
public class TbPhotoController {
    //日志系统
    private final Logger logger = LoggerFactory.getLogger(TbPhotoController.class);
    @Autowired
    PhotoInterFace photoInterFace;

}
