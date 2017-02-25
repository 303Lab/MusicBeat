package com.musicbeat.web.mapper;

import com.musicbeat.web.model.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AlbumMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Album record);

    int insertSelective(Album record);

    Album selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKeyWithBLOBs(Album record);

    int updateByPrimaryKey(Album record);

    List<Integer> selectByAlbumName(@Param("name") String name, @Param("like") Boolean like);

    List<Album> selectAlbumsByAlbumName(@Param("name") String name, @Param("like") Boolean like);

    List<Integer> selectByReleaseTime(Map<String, Object> map);

    List<Album> selectMusicsBySingerId(Integer id);

    List<Album> selectAllByReleaseTime();

    Album selectSingerById(Integer id);

    Album selectMusicsById(Integer id);
}