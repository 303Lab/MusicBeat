package com.musicbeat.web.mapper;

import com.musicbeat.web.model.Flow;
import java.util.Date;

public interface FlowMapper {
    int deleteByPrimaryKey(Date time);

    int insert(Flow record);

    int insertSelective(Flow record);

    Flow selectByPrimaryKey(Date time);

    int updateByPrimaryKeySelective(Flow record);

    int updateByPrimaryKey(Flow record);
}