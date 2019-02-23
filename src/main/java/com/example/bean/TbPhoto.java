package com.example.bean;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 相册类实体类，对应数据库tb_photo
 * @author RJSETTER
 * @Date 2019/2/22
 */
@Table(name="tb_photo")
public class TbPhoto {
    @Column(name="photo_id")
    private Integer photoId;
    @Column(name="user_id")
    private Integer userId;
    @Column(name="photo_name")
    private String photoName;
    @Column(name="photo_addr")
    private String photoAddr;
    @Column(name="photo_info")
    private String photoInfo;
    @Column(name="photo_time")
    private String photoTime;

    @Override
    public String toString(){
        return "message{" +
                "photoId='" + photoId + '\'' +
                ", userId='" + userId + '\'' +
                ", photoName='" + photoName + '\'' +
                ", photoAddr='" + photoAddr + '\'' +
                ", photoInfo='" + photoInfo + '\'' +
                ", photoTime='" + photoTime + '\'' +
                '}';
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoAddr() {
        return photoAddr;
    }

    public void setPhotoAddr(String photoAddr) {
        this.photoAddr = photoAddr;
    }

    public String getPhotoInfo() {
        return photoInfo;
    }

    public void setPhotoInfo(String photoInfo) {
        this.photoInfo = photoInfo;
    }

    public String getPhotoTime() {
        return photoTime;
    }

    public void setPhotoTime(String photoTime) {
        this.photoTime = photoTime;
    }
}
