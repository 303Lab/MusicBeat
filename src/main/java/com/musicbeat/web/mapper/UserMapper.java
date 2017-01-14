package com.musicbeat.web.mapper;

import com.musicbeat.web.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByPrimaryKey(Integer id);

    List<User> selectByUserName(@Param("username") String username);

    List<User> selectByUserNameSingle(@Param("username") String username);

    List<User> selectByRealName(@Param("realname")String realname);

    List<User> selectAdmin();

    List<User> selectByPhone(@Param("phone")String phone);

    List<User> selectByPhoneSingle(@Param("phone")String phone);

    List<User> selectByEmail(@Param("email")String email);

    List<User> selectByEmailSingle(@Param("email")String email);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
}