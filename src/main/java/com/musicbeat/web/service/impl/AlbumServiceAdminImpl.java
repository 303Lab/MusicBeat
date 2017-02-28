package com.musicbeat.web.service.impl;

import com.musicbeat.web.mapper.AlbumMapper;
import com.musicbeat.web.mapper.MusicAlbumMapper;
import com.musicbeat.web.mapper.SingerAlbumMapper;
import com.musicbeat.web.mapper.SingerMapper;
import com.musicbeat.web.model.Album;
import com.musicbeat.web.model.Singer;
import com.musicbeat.web.model.SingerAlbum;
import com.musicbeat.web.service.AlbumServiceAdmin;
import com.musicbeat.web.utils.UploadFile;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by gyz on 2017/2/25.
 */
@Service
public class AlbumServiceAdminImpl implements AlbumServiceAdmin{
    @Resource
    private AlbumMapper albumMapper;
    @Resource
    private SingerMapper singerMapper;
    @Resource
    private SingerAlbumMapper singerAlbumMapper;
    @Resource
    private MusicAlbumMapper musicAlbumMapper;

    @Override
    public List<Album> findAlbumByName(String name, Boolean like)
    {
        return albumMapper.selectAlbumsByAlbumName(name,false);
    }

    @Override
    public List<Album> findAlbumAll()
    {
        return albumMapper.selectAll();
    }

    @Override
    public Album findByAlbumId(Integer id)
    {
        return albumMapper.selectByPrimaryKey(id);

    }



    @Override
    public boolean add(HttpServletRequest request,Album album, Integer singerid)
    {
        albumMapper.insert(album);
        String sid = singerid.toString();
        Integer albumid = album.getId();
        String aid = albumid.toString();

        System.out.println("++++++++"+request.getSession().getServletContext().getRealPath("")+"+++++++++++++");
        String pathname = "src\\main\\webapp\\WEB-INF\\resources\\music\\"+sid+"\\"+aid+"\\";
        UploadFile.buildFolder(pathname);
        album.setId(albumid);
        String sourcefile = album.getPicture();
        if (sourcefile != null) {
            UploadFile.saveimgFile(pathname,sourcefile,aid);
            album.setPicture(pathname+album.getName()+".jpg");
        }
        else
        {
            album.setPicture("src\\main\\webapp\\WEB-INF\\resources\\music\\albumdefault.jpg");
        }
        albumMapper.updateByPrimaryKeySelective(album);
        Singer newsinger = singerMapper.selectByPrimaryKey(singerid);
        Album newnewalbum = albumMapper.selectByPrimaryKey(albumid);

       // SingerAlbum record=new SingerAlbum(newsinger.getId(),newnewalbum.getId());

        singerAlbumMapper.insert(newsinger.getId(),newnewalbum.getId());
        return true;
    }

    @Override
    public boolean update(HttpServletRequest request,Album album)
    {
        Integer albumid = album.getId();
        String aid = albumid.toString();
        String sourcefile = album.getPicture();
        Integer singerid =  singerAlbumMapper.selectSingerIdByAlbumId(albumid);
        if (sourcefile != null) {

            String pathname = "src\\main\\webapp\\WEB-INF\\resources\\music\\"+singerid.toString()+"\\"+aid+"\\";
            UploadFile.saveimgFile(pathname,sourcefile,aid);
            album.setPicture(pathname+album.getName()+".jpg");
        }
        albumMapper.updateByPrimaryKeySelective(album);
        return true;
    }

    @Override
    public boolean delete(HttpServletRequest request,Album album)
    {
        Integer aid = album.getId();
        List<Integer> mid = musicAlbumMapper.selectMusicIdByAlbumId(aid);
        Integer sid = singerAlbumMapper.selectSingerIdByAlbumId(aid);

        if (mid.isEmpty())
        {
            String sourcefile = album.getPicture();
            String filename = UploadFile.getFileNameByPath(sourcefile);
            if ((!filename.equals("albumdefault.jpg"))&&(filename!=null))
            {
                UploadFile.deleteFile(album.getPicture());
            }

            Singer singer=singerMapper.selectByPrimaryKey(sid);
            UploadFile.DeleteFolder("src\\main\\webapp\\WEB-INF\\resources\\music\\"+singer.getId().toString()+"\\"+album.getId().toString());
            singerAlbumMapper.deleteByPrimaryKey(sid,aid);
            albumMapper.deleteByPrimaryKey(aid);
            return true;
        }
        return false;
    }

}
