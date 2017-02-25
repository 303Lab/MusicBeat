package com.musicbeat.web.mapper;

import com.musicbeat.web.model.PlayList;
import org.apache.ibatis.annotations.Param;

public interface PlayListMapper {
    int deleteByPrimaryKey(@Param("mid") Integer mid, @Param("uid") Integer uid);

    int insert(@Param("mid") Integer mid, @Param("uid") Integer uid);

    int insertSelective(@Param("mid") Integer mid, @Param("uid") Integer uid);

    PlayList selectByUserId(Integer userId);
}