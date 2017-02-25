package com.musicbeat.web.mapper;

import com.musicbeat.web.model.MusicLabel;
import org.apache.ibatis.annotations.Param;

public interface MusicLabelMapper {
    int deleteByPrimaryKey(@Param("mid") Integer mid, @Param("lid") Integer lid);

    int insert(MusicLabel record);

    int insertSelective(MusicLabel record);
}