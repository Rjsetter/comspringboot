package com.example.service;

import com.example.bean.TbPhoto;

import java.util.List;

/**
 * 业务层接口，Photo模块
 * 相册管理：上传图片到自己的相册，删除相册中的照片，查看上传的照片。
 */
public interface PhotoInterFace {

    /**
     * 添加图片接口
     * @param tbPhoto
     * @return
     */
    public int addPhoto(TbPhoto tbPhoto);

    /**
     * 根据图片主键photo_id删除相片
     * @param photoId
     * @return
     */
    public int deletePhoto(int photoId);

    /**
     * 根据图片主键Photo_id查询图片信息
     * @param photoId
     * @return
     */
    public TbPhoto findOnePhoto(int photoId);

    /**
     * 根据用户Id查询该用户下的所有图片
     * @param tbPhoto
     * @return
     */
    public List<TbPhoto> findAllPhoto(TbPhoto tbPhoto);
}
