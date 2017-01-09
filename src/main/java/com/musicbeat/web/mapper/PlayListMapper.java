package com.musicbeat.web.mapper;

import com.musicbeat.web.model.PlayList;
import org.apache.ibatis.annotations.Param;

public interface PlayListMapper {
    int deleteByPrimaryKey(@Param("mid") Integer mid, @Param("uid") Integer uid);

    int insert(PlayList record);

    int insertSelective(PlayList record);
}