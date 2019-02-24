package com.example.service.impl;

import com.example.bean.TbComment;
import com.example.dao.TbCommentDao;
import com.example.service.CommentInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务接口层实现，comment模块
 * @author RJSETTER
 * @Date 2019/2/24
 */
@Service
public class CommentInterFaceImpl implements CommentInterFace {
    @Autowired
    TbCommentDao tbCommentDao;

    @Override
    public int addComment(TbComment tbComment){
        return tbCommentDao.insert(tbComment);
    }

    @Override
    public int deleteComment(int commentId){
        return tbCommentDao.deleteByPrimaryKey(commentId);
    }

    @Override
    public TbComment findComment(int commentId){
        return tbCommentDao.selectByPrimaryKey(commentId);
    }

    @Override
    public List<TbComment> findAllComment(TbComment tbComment){
        return tbCommentDao.select(tbComment);
    }
}
