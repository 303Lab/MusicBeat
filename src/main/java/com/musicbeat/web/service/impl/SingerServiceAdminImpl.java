package com.musicbeat.web.service.impl;

import com.musicbeat.web.mapper.SingerAlbumMapper;
import com.musicbeat.web.mapper.SingerBandMapper;
import com.musicbeat.web.mapper.SingerMapper;
import com.musicbeat.web.model.Singer;
import com.musicbeat.web.service.SingerServiceAdmin;
import com.musicbeat.web.utils.UploadFile;
import org.omg.CORBA.portable.InputStream;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by gyz on 2017/2/25.
 */
@Service
public class SingerServiceAdminImpl implements SingerServiceAdmin{
    @Resource
    private SingerMapper singerMapper;
    @Resource
    private SingerAlbumMapper singerAlbumMapper;
    @Resource
    private SingerBandMapper singerBandMapper;

    @Override
    public List<Singer> findSingerAll()
    {
        return singerMapper.selectAll();
    }

    @Override
    public List<Singer> findBySingerName(String name, Boolean like)
    {
        return singerMapper.selectSingersBySingerName(name, false);
    }

    @Override
    public Singer findBySingerId(Integer id)
    {
        return singerMapper.selectByPrimaryKey(id);
    }
    @Override
    public void add(HttpServletRequest request,Singer singer){

        singerMapper.insert(singer);
        Integer id = singer.getId();

        singer.setId(id);

        String pathname="src\\main\\webapp\\WEB-INF\\resources\\music\\"+id.toString()+"\\";
        UploadFile.buildFolder(pathname);

        String sourcefile = singer.getPicture();
        if (sourcefile != null)
        {
            UploadFile.saveimgFile(pathname,sourcefile,id.toString());
            singer.setPicture(pathname+id.toString()+".jpg");
        }
        else
        {
            singer.setPicture("src\\main\\webapp\\WEB-INF\\resources\\music\\singerdefault.jpg");
        }
        singerMapper.updateByPrimaryKeySelective(singer);
    }



    @Override
    public void update(HttpServletRequest request,Singer singer)
    {
        Integer id = singer.getId();

        String sourcefile = singer.getPicture();

        if (sourcefile != null)
        {
            String pathname="src\\main\\webapp\\WEB-INF\\resources\\music\\"+id.toString()+"\\";
            UploadFile.saveimgFile(pathname,sourcefile,id.toString());
            singer.setPicture(pathname+id.toString()+".jpg");
        }

        Integer bid = UploadFile.BooleantoInter(singer.getBand());

        singerBandMapper.updateBySingerId(singer.getId(),bid);

        singerMapper.updateByPrimaryKeySelective(singer);
    }

    @Override
    public boolean delete(HttpServletRequest request,Singer singer)
    {
        Integer sid = singer.getId();
        List<Integer> aid = singerAlbumMapper.selectAlbumIdBySingerId(sid);
        if(aid.isEmpty())
        {
            String sourcefile = singer.getPicture();
            String filename = UploadFile.getFileNameByPath(sourcefile);
            if ((!filename.equals("singerdefault.jpg"))&&(filename!=null))
            {
                UploadFile.deleteFile(singer.getPicture());
            }

            Integer bid = UploadFile.BooleantoInter(singer.getBand());
            singerBandMapper.deleteByPrimaryKey(sid,bid);
            UploadFile.DeleteFolder("src\\main\\webapp\\WEB-INF\\resources\\music\\"+singer.getName()+"\\");
            singerMapper.deleteByPrimaryKey(sid);

            return true;
        }
        return false;

    }

    @Override
    public void addBand(Integer mid,Integer band)
    {
        //singerBandMapper.insert(mid,band);
    }

}
