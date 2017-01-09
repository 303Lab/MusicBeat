package com.musicbeat.web.mapper;

import com.musicbeat.web.model.SingerBand;
import org.apache.ibatis.annotations.Param;

public interface SingerBandMapper {
    int deleteByPrimaryKey(@Param("sid") Integer sid, @Param("bid") Integer bid);

    int insert(SingerBand record);

    int insertSelective(SingerBand record);
}