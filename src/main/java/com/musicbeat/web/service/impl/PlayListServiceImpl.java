package com.musicbeat.web.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.musicbeat.web.mapper.*;
import com.musicbeat.web.model.Music;
import com.musicbeat.web.model.viewModel.MusicViewModel;
import com.musicbeat.web.service.MusicService;
import com.musicbeat.web.service.PlayListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.Iterator;
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
    @Resource
    private MusicService musicService;

    @Override
    public void addMusicToList(Integer uid,Integer mid) {
        playListMapper.insert(mid, uid);
    }

    @Override
    public void add(Integer uid,List<Integer> mids) {
        Iterator it = mids.iterator();
        while(it.hasNext()) {
            addMusicToList(uid,(Integer)it.next());
        }
    }

    @Override
    public void deleteMusicFromList(Integer uid,Integer mid) {
        playListMapper.deleteByPrimaryKey(mid, uid);
    }

    @Override
    public JSONArray getByUser(Integer userId) {
        List<Music> musicList = playListMapper.selectByUserId(userId).getMusics();
        JSONArray mvs = new JSONArray();
        for(Music music:musicList) {
            MusicViewModel mv = musicService.setMusicViewMode(music);
            mvs.add(mv);
        }
        return mvs;
    }

    //传过来音乐实体类，通过音乐找到链接地址？调用浏览器拦截下载？
    @Override
    public String downloadMusic(Integer musicId) {
        Music music = musicMapper.selectByMusicId(musicId);
        String url = music.getLink();
        return url;
    }
}
