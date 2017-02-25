package com.musicbeat.web.mapper;

import com.musicbeat.web.model.Label;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LabelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Label record);

    int insertSelective(Label record);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);

    Integer selectByName(@Param("name") String name, @Param("like") Boolean like);

    Label selectById(Integer id);

    Label selectLabelByName(@Param("name") String name, @Param("like") Boolean like);

    List<Label> selectAll();
}