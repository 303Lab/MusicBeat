package com.musicbeat.web.mapper;

import com.musicbeat.web.model.LabelGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LabelGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LabelGroup record);

    int insertSelective(LabelGroup record);

    LabelGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LabelGroup record);

    int updateByPrimaryKey(LabelGroup record);

    // LabelGroup add by gya
    List<LabelGroup> selectLabelGroupByName(@Param("name")String name, @Param("like")Boolean like);
}