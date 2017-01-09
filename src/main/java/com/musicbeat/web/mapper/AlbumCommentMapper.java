package com.musicbeat.web.mapper;

import com.musicbeat.web.model.AlbumComment;
import org.apache.ibatis.annotations.Param;

public interface AlbumCommentMapper {
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("uid") Integer uid, @Param("aid") Integer aid);

    int insert(AlbumComment record);

    int insertSelective(AlbumComment record);

    AlbumComment selectByPrimaryKey(@Param("id") Integer id, @Param("uid") Integer uid, @Param("aid") Integer aid);

    int updateByPrimaryKeySelective(AlbumComment record);

    int updateByPrimaryKey(AlbumComment record);
}