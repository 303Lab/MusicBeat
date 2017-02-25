package com.musicbeat.web.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.musicbeat.web.mapper.AlbumMapper;
import com.musicbeat.web.mapper.LabelMapper;
import com.musicbeat.web.mapper.MusicMapper;
import com.musicbeat.web.mapper.SingerMapper;
import com.musicbeat.web.model.Album;
import com.musicbeat.web.model.Label;
import com.musicbeat.web.model.Music;
import com.musicbeat.web.model.Singer;
import com.musicbeat.web.model.viewModel.AlbumViewModel;
import com.musicbeat.web.model.viewModel.MusicViewModel;
import com.musicbeat.web.model.viewModel.SingerViewModel;
import com.musicbeat.web.service.MusicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.musicbeat.web.utils.ModelConvertUtil.convert2ViewModel;

/**
 * Created by Administrator on 2017/2/13.
 */
@Service("MusicService")
public class MusicServiceImpl implements MusicService {

    @Resource
    private MusicMapper musicMapper;
    @Resource
    private AlbumMapper albumMapper;
    @Resource
    private SingerMapper singerMapper;
    @Resource
    private LabelMapper labelMapper;

    /****************************************歌曲*************************************/

    @Override
    public List<Music> getAll() {
        return musicMapper.selectAll();
    }

    @Override
    public MusicViewModel getByMusicId(Integer id) {
        Music music = musicMapper.selectByMusicId(id);
        MusicViewModel mv = setMusicViewMode(music);
        return mv;
    }

    @Override
    public List<Music> getByMusicName(String Mname, Boolean like) {
        return musicMapper.selectMusicsByMusicName(Mname, like);
    }

    @Override
    public List<Music> getBySingerName(String Sname, Boolean like) {
        List<Music> musicList = new ArrayList<>();
        List<Integer> sIds = singerMapper.selectSingerIdByName(Sname, false);
        for (Integer id : sIds) {
            List<Album> albums = albumMapper.selectMusicsBySingerId(id);
            for (Album album : albums) {
                List<Music> musics = album.getMusics();
                for (Music music : musics) {
                    musicList.add(music);
                }
            }
        }
        return musicList;
    }

    @Override
    public Album selectMusicsById(Integer id) {
        return albumMapper.selectMusicsById(id);
    }

    @Override
    public JSONArray selectBySingerId(Integer id) {
        JSONArray mvs = new JSONArray();

        List<Album> albums = albumMapper.selectMusicsBySingerId(id);
        if (albums.isEmpty()) {
            logger.info("can't find albums");
            return null;
        }
        for (Album album : albums) {
            Singer singer = album.getSinger();

            List<AlbumViewModel> albumViewModels = this.getByAlbum(album);
            if (albumViewModels.isEmpty()) {
                logger.info("can't change the model");
                return null;
            }

            SingerViewModel singerViewModel = (SingerViewModel) convert2ViewModel(singer);
            singerViewModel.setMusics(albumViewModels);

            mvs.add(singerViewModel);
        }
        return mvs;
    }

    @Override
    public List<Album> selectMusicsBySingerId(Integer id) {
        return albumMapper.selectMusicsBySingerId(id);
    }

    /****************************************专辑*************************************/
    @Override
    public Album selectAlbumByAlbumId(Integer id) {
        return albumMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Album> getAlbumsByAlbumName(String Aname, Boolean like) {
        return albumMapper.selectAlbumsByAlbumName(Aname, false);
    }

    @Override
    public Singer selectAlbumsById(Integer id) {
        return singerMapper.selectAlbumsById(id);
    }

    @Override
    public Music selectAlbumById(Integer id) {
        return musicMapper.selectAlbumById(id);
    }

    /****************************************歌手*************************************/
    @Override
    public Album selectSingerById(Integer id) {
        return albumMapper.selectSingerById(id);
    }

    @Override
    public List<Singer> selectAll() {
        return singerMapper.selectAll();
    }

    /*
    * 可用于华语男、女、组合歌手；欧美男、女、组合歌手
    * 日韩男、女、组合歌手需要做两次，再合并
    * */
    @Override
    public List<Singer> selectByLangAndGenderAndBand(String lang, Boolean gender, Boolean isBand) {
        return singerMapper.selectByLangGenderBand(lang, gender, isBand);
    }

    /****************************************其他*************************************/
    @Override
    public List<Label> selectAllLabers() {
        return labelMapper.selectAll();
    }

    /*music分为三个类型的
        * 只有music基本信息的
        * 有music-album信息的
        * 有singer-album-music信息的
        *
        * 只处理第一种
        * */
    @Override
    public MusicViewModel setMusicViewMode(Music music) {
        String aPicture = "";
        String aName = "";
        String sName = "";

        Music m = musicMapper.selectAlbumById(music.getId());

        if (m != null) {
            Album a = m.getAlbum();
            if (a != null) {
                aPicture = a.getPicture();
                aName = a.getName();
                Album album = albumMapper.selectSingerById(a.getId());
                if (album != null) {
                    Singer s = album.getSinger();
                    if (s != null) {
                        sName = s.getName();
                    }
                }
            }
        }

        MusicViewModel musicViewModel = (MusicViewModel) convert2ViewModel(music);

        if (aPicture != "") {
            musicViewModel.setaPicture(aPicture);
        }

        if (aName != "") {
            musicViewModel.setsName(aName);
        }

        if (sName != "") {
            musicViewModel.setsName(sName);
        }

        return musicViewModel;
    }

    /*通过专辑获取相应格式的音乐集*/
    private List<AlbumViewModel> getByAlbum(Album album) {
        List<AlbumViewModel> mvs = new ArrayList<>();

        Integer mId = new Integer(0);
        String mName = "";

        if (album == null) {
            logger.info("album is not existed");
            return null;
        }

        List<Music> musics = album.getMusics();
        if (musics.isEmpty()) {
            logger.info("can't find musics");
            return null;
        }
        for (Music music : musics) {
            mId = music.getId();
            mName = music.getName();
            AlbumViewModel albumViewModel = (AlbumViewModel) convert2ViewModel(album);

            if (mId != 0) {
                albumViewModel.setmId(mId);
            }

            if (mName != "") {
                albumViewModel.setmName(mName);
            }

            mvs.add(albumViewModel);
        }
        return mvs;
    }
}
