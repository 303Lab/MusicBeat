package com.musicbeat.web.service;

import com.musicbeat.web.model.AlbumComment;
import com.musicbeat.web.model.MusicComment;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/2/13.
 */
public interface CommentService {
    Logger logger = Logger.getLogger(CommentService.class);

    //check the login state of user
    void addCommentMusic(MusicComment musicComment);

    //check the login state of user
    void addCommentAlbum(AlbumComment albumComment);
}
