package com.musicbeat.web.service;

import com.alibaba.fastjson.JSONArray;
import com.musicbeat.web.model.Album;
import com.musicbeat.web.model.Label;
import com.musicbeat.web.model.Music;
import com.musicbeat.web.model.Singer;
import com.musicbeat.web.model.viewModel.MusicViewModel;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Administrator on 2017/2/13.
 */
public interface MusicService {
    Logger logger = Logger.getLogger(MusicService.class);

    /****************************************歌曲*************************************/
    /*获得全部歌曲*/
    List<Music> getAll();

    /*通过音乐id找到音乐*/
    MusicViewModel getByMusicId(Integer id);

    /*通过音乐名查询歌曲集*/
    List<Music> getByMusicName(String Mname, Boolean like);

    /*通过歌手名字查询歌曲集*/
    List<Music> getBySingerName(String Sname, Boolean like);

    /*通过专辑id获得旗下的所有音乐*/
    Album selectMusicsById(Integer id);

    /*从singer的id到音乐集*/
    JSONArray selectBySingerId(Integer id);

    /*通过歌手id找到旗下所有专辑下的所有音乐*/
    List<Album> selectMusicsBySingerId(Integer id);

    /****************************************专辑*************************************/
    /*通过专辑id得到专辑*/
    Album selectAlbumByAlbumId(Integer id);

    /*通过专辑名字查询专辑集*/
    List<Album> getAlbumsByAlbumName(String Aname, Boolean like);

    /*通过歌手id获得旗下的所有专辑*/
    Singer selectAlbumsById(Integer id);

    /*通过音乐id找到唯一专辑*/
    Music selectAlbumById(Integer id);

    /****************************************歌手*************************************/
    /*通过专辑id找到唯一歌手*/
    Album selectSingerById(Integer id);

    /*获得全部歌手*/
    List<Singer> selectAll();

    /*获得歌手列表*/
    List<Singer> selectByLangAndGenderAndBand(String lang, Boolean gender, Boolean isBand);

    /****************************************其他*************************************/
    /*获得全部标签*/
    List<Label> selectAllLabers();

    /*将music转化为musicViewModel*/
    MusicViewModel setMusicViewMode(Music music);

}
