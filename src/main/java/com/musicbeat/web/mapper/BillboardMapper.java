package com.musicbeat.web.mapper;

import com.musicbeat.web.model.Billboard;

import java.util.Date;
import java.util.List;

public interface BillboardMapper {
    int deleteByPrimaryKey(Date time);

    int insert(Billboard record);

    int insertSelective(Billboard record);

    Billboard selectByPrimaryKey(Date time);

    int updateByPrimaryKeySelective(Billboard record);

    int updateByPrimaryKey(Billboard record);

    List<Billboard> selectByPlayAmount(Date time);

    List<Billboard> selectByDownloadAmount(Date time);
}