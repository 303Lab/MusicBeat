package com.musicbeat.web.service;

import com.musicbeat.web.model.Music;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by gyz on 2017/2/25.
 */
public interface MusicServiceAdmin {
    Logger logger = Logger.getLogger(MusicServiceAdmin.class);

    List<Music> findMusicByName(String name,Boolean like);

    List<Music> findMusicAll();

    Music findByMusicId(Integer id);

    void add(HttpServletRequest request,Music music, Integer singerId, Integer albumId);

    void update(HttpServletRequest request,Music music);

    void delete(HttpServletRequest request,Music music);

    void addLyric(Music music);

    void editLabel(String[] type,Integer mid);

    void updateLabel(String[] type,Integer mid);

     void deleteMusicLabel(Music music);


}
