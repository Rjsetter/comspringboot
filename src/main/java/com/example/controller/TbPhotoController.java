package com.example.controller;

import com.example.bean.TbPhoto;
import com.example.service.PhotoInterFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    //添加相册入口
    @GetMapping("add")
    public String add(){return "photo/add";}
    //添加相册接口
    @PostMapping("addPhoto")
    @ResponseBody
    public String addPhoto(int userId,String photoName, String photoAddr,String photoInfo, String photoTime){
        TbPhoto tbPhoto = new TbPhoto();
        tbPhoto.setUserId(userId);
        tbPhoto.setPhotoName(photoName);
        tbPhoto.setPhotoAddr(photoAddr);
        tbPhoto.setPhotoInfo(photoInfo);
        tbPhoto.setPhotoTime(photoTime);
        int flag = photoInterFace.addPhoto(tbPhoto);
        if(flag>0){
            logger.info("添加相片信息如下："+tbPhoto);
            return "添加相册信息如下："+tbPhoto.toString();
        }
        return "添加相册信息失败";
    }

    //删除信息
    @PostMapping("delete")
    @ResponseBody
    public String delete(int photoId){
        TbPhoto flag = photoInterFace.findOnePhoto(photoId);
        if(flag!=null){
            logger.info("删除相册信息为："+flag);
            photoInterFace.deletePhoto(photoId);
            return "删除相册信息为："+flag;
        }
        return "没有图片信息，删除错误！";
    }

    //根据图片ID查询相片信息
    @PostMapping("findOne")
    @ResponseBody
    public String findOne(int photoId){
        TbPhoto photo = photoInterFace.findOnePhoto(photoId);
        if(photo !=null) {
            logger.info("查询图片ID为" + photoId + "的图片信息为：" + photo);
            return photo.toString(); }
        return "没有图片信息！";
    }


    //根据用户ID查询相片信息
    @PostMapping("findAll")
    @ResponseBody
    public String findAll(int userId){
        TbPhoto tbPhoto = new TbPhoto();
        tbPhoto.setUserId(userId);
        List<TbPhoto> photos = photoInterFace.findAllPhoto(tbPhoto);
        if(photos !=null) {
            logger.info("查询用户ID为" + userId + "的图片信息为：" + photos);
            return photos.toString(); }
        return "没有图片信息！";
    }
}
