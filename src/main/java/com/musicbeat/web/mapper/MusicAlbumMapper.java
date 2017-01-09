package com.musicbeat.web.mapper;

import com.musicbeat.web.model.MusicAlbum;
import org.apache.ibatis.annotations.Param;

public interface MusicAlbumMapper {
    int deleteByPrimaryKey(@Param("mid") Integer mid, @Param("aid") Integer aid);

    int insert(MusicAlbum record);

    int insertSelective(MusicAlbum record);
}