package com.musicbeat.web.mapper;

import com.musicbeat.web.model.SingerAlbum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SingerAlbumMapper {
    int deleteByPrimaryKey(@Param("sid") Integer sid, @Param("aid") Integer aid);

    int insert(@Param("sid") Integer sid, @Param("aid") Integer aid);

    int insertSelective(SingerAlbum record);

	// add by gyz
    List<Integer> selectAlbumIdBySingerId(Integer singerId);
    // add by gyz
    Integer selectSingerIdByAlbumId(Integer aid);
}