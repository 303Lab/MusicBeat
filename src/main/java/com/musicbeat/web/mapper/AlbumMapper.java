package com.musicbeat.web.mapper;

import com.musicbeat.web.model.Album;

public interface AlbumMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Album record);

    int insertSelective(Album record);

    Album selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKeyWithBLOBs(Album record);

    int updateByPrimaryKey(Album record);
}