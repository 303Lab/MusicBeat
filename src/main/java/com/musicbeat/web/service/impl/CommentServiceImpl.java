package com.musicbeat.web.service.impl;

import com.musicbeat.web.mapper.AlbumCommentMapper;
import com.musicbeat.web.mapper.MusicCommentMapper;
import com.musicbeat.web.model.AlbumComment;
import com.musicbeat.web.model.MusicComment;
import com.musicbeat.web.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/2/13.
 */
@Service("CommentService")
public class CommentServiceImpl implements CommentService {

    @Resource
    private AlbumCommentMapper albumCommentMapper;
    @Resource
    private MusicCommentMapper musicCommentMapper;

    @Override
    public void addCommentMusic(MusicComment musicComment) {
        //返回插入位置，-1表示插入失败？
        //只管插入 不判断
        musicCommentMapper.insertSelective(musicComment);
        logger.info("succeed to insert comments of music");
    }

    @Override
    public void addCommentAlbum(AlbumComment albumComment) {
        albumCommentMapper.insertSelective(albumComment);
        logger.info("succeed to insert comments of album");
    }
}
