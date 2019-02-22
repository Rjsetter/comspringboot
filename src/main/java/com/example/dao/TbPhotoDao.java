package com.example.dao;

import com.example.bean.TbPhoto;
import com.example.dao.baseDao.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbPhotoDao extends MyMapper<TbPhoto> {
}
