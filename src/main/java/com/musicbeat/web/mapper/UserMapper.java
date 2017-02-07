package com.musicbeat.web.mapper;

import com.musicbeat.web.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByPrimaryKey(Integer id);

    List<User> selectByUserName(@Param("username") String username, @Param("like") Boolean like);

    List<User> selectByRealName(@Param("realname")String realname, @Param("like") Boolean like);

    List<User> selectAdmin();

    List<User> selectByPhone(@Param("phone")String phone, @Param("like") Boolean like);

    List<User> selectByEmail(@Param("email")String email, @Param("like") Boolean like);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
}