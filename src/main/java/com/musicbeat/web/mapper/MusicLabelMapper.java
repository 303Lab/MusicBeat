package com.musicbeat.web.mapper;

import com.musicbeat.web.model.MusicLabel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MusicLabelMapper {
    int deleteByPrimaryKey(@Param("mid") Integer mid, @Param("lid") Integer lid);

    int insert(@Param("mid") Integer mid, @Param("lid") Integer lid);

    int insertSelective(MusicLabel record);

    //add by gyz
    List<Integer> selectMusicIdByLabelId(Integer lid);
    //add by gyz
    List<Integer> selectLabelIdByMusicId(Integer mid);
    //add by gyz
    int updateByMusicId(@Param("mid") Integer mid,@Param("lid") Integer lid);
}