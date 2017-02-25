package com.musicbeat.web.service;

import com.musicbeat.web.model.Music;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Administrator on 2017/2/13.
 */
public interface PlayListService {
    Logger logger = Logger.getLogger(PlayListService.class);

    /*从数据库中取出记录*/
    List<Music> getByUser(Integer userId);

    /*添加歌曲到列表*/
    void addMusicToList(Integer uid, Integer mid);

    /*从列表删除歌曲*/
    void deleteMusicFromList(Integer uid, Integer mid);

    /*下载歌曲*/
    String downloadMusic(Integer musicId);
}
