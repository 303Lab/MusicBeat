package com.musicbeat.web.mapper;

import com.musicbeat.web.model.MusicComment;
import org.apache.ibatis.annotations.Param;

public interface MusicCommentMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("uid") Integer uid, @Param("mid") Integer mid);

    int insert(MusicComment record);

    int insertSelective(MusicComment record);

    MusicComment selectByPrimaryKey(@Param("id") Integer id, @Param("uid") Integer uid, @Param("mid") Integer mid);

    int updateByPrimaryKeySelective(MusicComment record);

    int updateByPrimaryKeyWithBLOBs(MusicComment record);
}