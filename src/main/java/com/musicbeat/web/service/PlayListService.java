package com.musicbeat.web.service;

import com.alibaba.fastjson.JSONArray;
import com.musicbeat.web.model.Label;
import com.musicbeat.web.model.Music;
import com.musicbeat.web.model.PlayList;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Administrator on 2017/2/13.
 */
public interface PlayListService {
    Logger logger = Logger.getLogger(PlayListService.class);

    /*从数据库中取出记录*/
    JSONArray getByUser(Integer userId);

    /*添加歌曲到列表*/
    void addMusicToList(Integer uid,Integer mid);

    void add(Integer uid,List<Integer> mids);

    /*从列表删除歌曲*/
    void deleteMusicFromList(Integer uid,Integer mid);

    /*下载歌曲*/
    String downloadMusic(Integer musicId);
}
