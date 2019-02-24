package com.example.service.impl;

import com.example.bean.TbPhoto;
import com.example.dao.TbPhotoDao;
import com.example.service.PhotoInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务接口层实现，photo模块
 * @author RJSETTER
 * @Date 2019/2/22
 */
@Service
public class PhotoInterFaceImpl implements PhotoInterFace {
    @Autowired
    TbPhotoDao tbPhotoDao;

    @Override
    public int addPhoto(TbPhoto tbPhoto){
        return tbPhotoDao.insert(tbPhoto);
    }

    @Override
    public int deletePhoto(int photoId){
        return tbPhotoDao.deleteByPrimaryKey(photoId);
    }
    @Override
    public TbPhoto findOnePhoto(int photoId){
        return tbPhotoDao.selectByPrimaryKey(photoId);
    }
    @Override
    public List<TbPhoto> findAllPhoto(TbPhoto tbPhoto){
        //通过设置tbPhoto的userid,查询相应用户的所有信息
        return tbPhotoDao.select(tbPhoto);
    }
}
