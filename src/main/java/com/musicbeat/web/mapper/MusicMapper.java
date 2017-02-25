package com.musicbeat.web.mapper;

import com.musicbeat.web.model.Music;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MusicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Music record);

    int insertSelective(Music record);

    int updateByPrimaryKeySelective(Music record);

    int updateByPrimaryKey(Music record);

    Music selectByMusicId(Integer id);

    List<Integer> selectByMusicName(@Param("name") String name, @Param("like") Boolean like);

    List<Music> selectMusicsByMusicName(@Param("name") String name, @Param("like") Boolean like);

    Music selectAlbumById(Integer id);

    List<Music> selectAll();

    Music selectLabelsById(Integer id);

}