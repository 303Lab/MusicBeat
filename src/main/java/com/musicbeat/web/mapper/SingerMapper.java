package com.musicbeat.web.mapper;

import com.musicbeat.web.model.Singer;

public interface SingerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Singer record);

    int insertSelective(Singer record);

    Singer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Singer record);

    int updateByPrimaryKeyWithBLOBs(Singer record);

    int updateByPrimaryKey(Singer record);
}