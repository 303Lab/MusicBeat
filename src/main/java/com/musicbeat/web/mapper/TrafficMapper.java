package com.musicbeat.web.mapper;

import com.musicbeat.web.model.Traffic;

public interface TrafficMapper {
    int deleteByPrimaryKey(String id);

    int insert(Traffic record);

    int insertSelective(Traffic record);

    Traffic selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Traffic record);

    int updateByPrimaryKey(Traffic record);
}