package com.musicbeat.web.mapper;

import com.musicbeat.web.model.Music;

public interface MusicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Music record);

    int insertSelective(Music record);

    Music selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Music record);

    int updateByPrimaryKey(Music record);
}