package com.musicbeat.web.mapper;

import com.musicbeat.web.model.Singer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SingerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Singer record);

    int insertSelective(Singer record);


    int updateByPrimaryKeySelective(Singer record);

    int updateByPrimaryKeyWithBLOBs(Singer record);

    int updateByPrimaryKey(Singer record);

    Singer selectByPrimaryKey(Integer id);

    List<Integer> selectSingerIdByName(@Param("name") String name, @Param("like") Boolean like);

    List<Singer> selectSingersBySingerName(@Param("name") String name, @Param("like") Boolean like);

    Singer selectAlbumsById(Integer id);

    List<Singer> selectAll();

    List<Singer> selectByLangGenderBand(@Param("lang") String lang, @Param("gender") Boolean gender, @Param("isBand") Boolean isBand);
}