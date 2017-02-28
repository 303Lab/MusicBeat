package com.musicbeat.web.mapper;

import com.musicbeat.web.model.SingerBand;
import org.apache.ibatis.annotations.Param;

public interface SingerBandMapper {
    int deleteByPrimaryKey(@Param("sid") Integer sid, @Param("bid") Integer bid);

    int insert(@Param("sid") Integer sid, @Param("bid") Integer bid);

    int insertSelective(SingerBand record);

    int updateBySingerId(@Param("sid") Integer sid, @Param("bid") Integer bid);

}