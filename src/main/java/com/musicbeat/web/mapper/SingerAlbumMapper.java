package com.musicbeat.web.mapper;

import com.musicbeat.web.model.SingerAlbum;
import org.apache.ibatis.annotations.Param;

public interface SingerAlbumMapper {
    int deleteByPrimaryKey(@Param("sid") Integer sid, @Param("aid") Integer aid);

    int insert(SingerAlbum record);

    int insertSelective(SingerAlbum record);
}