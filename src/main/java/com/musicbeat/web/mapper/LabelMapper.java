package com.musicbeat.web.mapper;

import com.musicbeat.web.model.Label;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LabelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(@Param("id") Integer id,@Param("gid") Integer gid,@Param("name") String name);

    int insertSelective(@Param("id") Integer id,@Param("gid") Integer gid,@Param("name") String name);

    int updateByPrimaryKeySelective(@Param("id") Integer id,@Param("gid") Integer gid,@Param("name") String name);

    int updateByPrimaryKey(@Param("id") Integer id,@Param("gid") Integer gid,@Param("name") String name);

    Integer selectByName(@Param("name") String name, @Param("like") Boolean like);

    Label selectById(Integer id);

    Label selectLabelByName(@Param("name") String name, @Param("like") Boolean like);

    List<Label> selectAll();

    //add by gyz id
    List<Integer> selectLabelIdByLabelGroupId(Integer gid);
    //add by gyz
    Integer selectLabelGroupIdByLabelId(Integer lid);


}