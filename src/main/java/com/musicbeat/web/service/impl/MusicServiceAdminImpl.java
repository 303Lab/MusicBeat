package com.musicbeat.web.service.impl;

import com.musicbeat.web.mapper.AlbumMapper;
import com.musicbeat.web.mapper.LabelMapper;
import com.musicbeat.web.mapper.MusicAlbumMapper;
import com.musicbeat.web.mapper.MusicLabelMapper;
import com.musicbeat.web.mapper.MusicMapper;
import com.musicbeat.web.mapper.SingerAlbumMapper;
import com.musicbeat.web.model.Label;
import com.musicbeat.web.model.Music;
import com.musicbeat.web.service.MusicServiceAdmin;
import com.musicbeat.web.utils.UploadFile;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by gyz on 2017/2/25.
 */
@Service
public class MusicServiceAdminImpl implements MusicServiceAdmin{
    @Resource
    private AlbumMapper albumMapper;

    @Resource
    private MusicMapper musicMapper;

    @Resource
    private MusicAlbumMapper musicAlbumMapper;
    @Resource
    private SingerAlbumMapper singerAlbumMapper;
    @Resource
    private MusicLabelMapper musicLabelMapper;

    @Resource
    private LabelMapper labelMapper;


    @Override
    public List<Music> findMusicByName(String name,Boolean like)
    {
        return musicMapper.selectMusicsByMusicName(name,false);
    }

    @Override
    public List<Music> findMusicAll()
    {
        return musicMapper.selectAll();
    }

    public Music findByMusicId(Integer id)
    {
        return musicMapper.selectByMusicId(id);
    }

    @Override
    public void add(HttpServletRequest request,Music music, Integer singerId, Integer albumId)
    {
        musicMapper.insert(music);
       // System.out.println("--------"+request.getSession().getServletContext().getContextPath()+"---------");
        System.out.println("++++++++" + request.getContextPath() + "\\WEB-INF\\resources\\music");
        String pathname = "src\\main\\webapp\\WEB-INF\\resources\\music\\"
                          + singerId.toString()
                          + "\\"
                          + albumId.toString()
                          + "\\";
        if (music.getLyrics() != null) {
            UploadFile.savelrcFile(pathname, music.getLyrics(), music.getName());    //上传歌曲文件
            music.setLyrics(pathname + music.getName() + ".lyr");
        }
        if (music.getLink() != null) {
            UploadFile.savemp3File(pathname, music.getLink(), music.getName());    //上传歌词文件
            music.setLink(pathname + music.getName() + ".mp3");
        }


        Integer musicid = music.getId();
        music.setId(musicid);

        musicMapper.updateByPrimaryKeySelective(music);


        musicAlbumMapper.insert(musicid,albumId);



    }

    @Override
    public void update(HttpServletRequest request,Music music)
    {
        Integer musicid=music.getId();
        Integer albumid=musicAlbumMapper.selectAlbumIDByMusicID(musicid);
        Integer singerid = singerAlbumMapper.selectSingerIdByAlbumId(albumid);

        String pathname = "src\\main\\webapp\\WEB-INF\\resources\\music\\"+singerid.toString()+"\\"+albumid.toString()+"\\";
        if (music.getLyrics() != null) {
            UploadFile.savelrcFile(pathname,music.getLyrics(),music.getName());    //上传歌曲文件
            music.setLyrics(pathname+music.getName()+".lyr");
        }
        if (music.getLink() != null) {
            UploadFile.savemp3File(pathname,music.getLink(),music.getName());    //上传歌词文件
            music.setLink(pathname+music.getName()+".mp3");

        }


        musicMapper.updateByPrimaryKeySelective(music);

    }

    @Override
    public void delete(HttpServletRequest request,Music music)
    {
        Integer musicId = music.getId();
        UploadFile.deleteFile(music.getLink());
        UploadFile.deleteFile(music.getLyrics());

        deleteMusicLabel(music);


        Integer albumId=musicAlbumMapper.selectAlbumIDByMusicID(musicId);

        musicAlbumMapper.deleteByPrimaryKey(musicId,albumId);
        musicMapper.deleteByPrimaryKey(musicId);

    }

    @Override
    public void addLyric(Music music)
    {

    }

    @Override
    public void editLabel(String[] type,Integer mid)
    {
        for (int i=0;i<type.length;i++)
        {
            Label label=labelMapper.selectLabelByName(type[i],false);

            musicLabelMapper.insert(mid,label.getId());
        }

    }

    @Override
    public void updateLabel(String[] type,Integer mid)
    {
        for (int i=0;i<type.length;i++)
        {
            Label label=labelMapper.selectLabelByName(type[i],false);

            musicLabelMapper.updateByMusicId(mid,label.getId());
        }

    }

    @Override
    public void deleteMusicLabel(Music music)
    {
        List<Integer> labelids = musicLabelMapper.selectLabelIdByMusicId(music.getId());
        for (int i=0;i<labelids.size();i++)
        {
            musicLabelMapper.deleteByPrimaryKey(music.getId(),labelids.get(i));
        }
    }




}
