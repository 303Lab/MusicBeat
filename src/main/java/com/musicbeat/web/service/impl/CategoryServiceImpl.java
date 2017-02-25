package com.musicbeat.web.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.musicbeat.web.mapper.AlbumMapper;
import com.musicbeat.web.mapper.BillboardMapper;
import com.musicbeat.web.mapper.LabelMapper;
import com.musicbeat.web.mapper.MusicMapper;
import com.musicbeat.web.model.Album;
import com.musicbeat.web.model.Billboard;
import com.musicbeat.web.model.Label;
import com.musicbeat.web.model.Music;
import com.musicbeat.web.model.Singer;
import com.musicbeat.web.model.viewModel.MusicViewModel;
import com.musicbeat.web.service.CategoryService;
import com.musicbeat.web.service.MusicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static com.musicbeat.web.utils.ModelConvertUtil.convert2ViewModel;

;

/**
 * Created by Administrator on 2017/2/13.
 */
@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private MusicMapper musicMapper;
    @Resource
    private MusicService musicService;
    @Resource
    private AlbumMapper albumMapper;
    @Resource
    private BillboardMapper billboardMapper;
    @Resource
    private LabelMapper labelMapper;

    @Override
    public JSONArray findByReleaseTime() {
        JSONArray musicVMs = new JSONArray();
        List<Album> albums = albumMapper.selectAllByReleaseTime();

        if (albums.isEmpty()) {
            logger.info("can't find albums");
            return null;
        }
        for (Album album : albums) {
            List<Music> musics = album.getMusics();
            String aPicture = album.getPicture();
            Singer singer = album.getSinger();
            String sName = singer.getName();

            if (musics.isEmpty()) {
                logger.info("can't find music");
                return null;
            }

            for (Music music : musics) {
                MusicViewModel musicViewModel = (MusicViewModel) convert2ViewModel(music);
                if (aPicture != null) {
                    musicViewModel.setaPicture(aPicture);
                }
                if (sName != null) {
                    musicViewModel.setsName(sName);
                }
                logger.info(musicViewModel);
                musicVMs.add(musicViewModel);
            }
        }
        return musicVMs;
    }

    @Override
    public JSONArray findByPlayAmount() throws ParseException {
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date date = dateFormat.parse("2017-2-16");

        //Date date = new Date(); 正常情况下每天晚11：59取当天的歌曲的点击量排行

        List<Billboard> billboards = billboardMapper.selectByPlayAmount(date);
        if (billboards.isEmpty()) {
            logger.info("no music");
            return null;
        }

        JSONArray mvs = new JSONArray();
        for (Billboard billboard : billboards) {
            if (null != billboard) {
                Music music = musicMapper.selectByMusicId(billboard.getMid());
                MusicViewModel mv = musicService.setMusicViewMode(music);
                mvs.add(mv);
            }
        }
        return mvs;
    }

    @Override
    public JSONArray findByDownloadAmount() throws ParseException {
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date date = dateFormat.parse("2017-2-16");//测试数据
        //Date date = new Date(); 正常情况下每天晚11：59取当天的歌曲的点击量排行

        List<Billboard> billboards = billboardMapper.selectByDownloadAmount(date);
        if (billboards.isEmpty()) {
            logger.info("no music");
            return null;
        }

        JSONArray mvs = new JSONArray();
        for (Billboard billboard : billboards) {
            if (null != billboard) {
                Music music = musicMapper.selectByMusicId(billboard.getMid());
                MusicViewModel mv = musicService.setMusicViewMode(music);
                mvs.add(mv);
            }
        }
        return mvs;
    }

    @Override
    public JSONArray findByLabelName(String name) {
        Label label = labelMapper.selectLabelByName(name, false);

        List<Music> musics = label.getMusics();
        JSONArray musicsViewModel = new JSONArray();

        for (Music music : musics) {
            musicsViewModel.add(musicService.setMusicViewMode(music));
        }
        return musicsViewModel;
    }
}
