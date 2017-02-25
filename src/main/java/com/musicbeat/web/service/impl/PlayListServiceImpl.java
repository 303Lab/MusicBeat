package com.musicbeat.web.service.impl;

import com.musicbeat.web.mapper.MusicMapper;
import com.musicbeat.web.mapper.PlayListMapper;
import com.musicbeat.web.model.Music;
import com.musicbeat.web.service.PlayListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/2/13.
 */
@Service("PlayListService")
public class PlayListServiceImpl implements PlayListService {
    @Resource
    private PlayListMapper playListMapper;
    @Resource
    private MusicMapper musicMapper;

    @Override
    public void addMusicToList(Integer uid, Integer mid) {
        playListMapper.insert(mid, uid);
    }

    @Override
    public void deleteMusicFromList(Integer uid, Integer mid) {
        playListMapper.deleteByPrimaryKey(mid, uid);
    }

    @Override
    public List<Music> getByUser(Integer userId) {
        return playListMapper.selectByUserId(userId).getMusics();
    }

    //传过来音乐实体类，通过音乐找到链接地址？调用浏览器拦截下载？
    @Override
    public String downloadMusic(Integer musicId) {
        Music music = musicMapper.selectByMusicId(musicId);
        String url = music.getLink();
        return url;
    }
}
