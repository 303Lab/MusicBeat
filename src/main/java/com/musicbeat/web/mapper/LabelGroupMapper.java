package com.musicbeat.web.mapper;

import com.musicbeat.web.model.LabelGroup;

public interface LabelGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LabelGroup record);

    int insertSelective(LabelGroup record);

    LabelGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LabelGroup record);

    int updateByPrimaryKey(LabelGroup record);
}