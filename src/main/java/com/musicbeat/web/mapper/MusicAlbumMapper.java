package com.musicbeat.web.mapper;

import com.musicbeat.web.model.MusicAlbum;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MusicAlbumMapper {
    int deleteByPrimaryKey(@Param("mid") Integer mid, @Param("aid") Integer aid);

    int insert(@Param("mid") Integer mid, @Param("aid") Integer aid);

    int insertSelective(@Param("mid") Integer mid, @Param("aid") Integer aid);


    //add by gyz
    Integer selectAlbumIDByMusicID(Integer mid);
    //add by gyz
    List<Integer> selectMusicIdByAlbumId(Integer aid);
}