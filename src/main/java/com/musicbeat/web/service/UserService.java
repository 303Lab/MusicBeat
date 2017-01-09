package com.musicbeat.web.service;

import com.musicbeat.web.model.User;

import java.util.List;

/**
 * 用户服务接口
 * Created by windawings on 2017/1/5
 */
public interface UserService {
  void add(User user);

  void update(User user);

  void delete(Integer id);

  List<User> findById(Integer id);

  List<User> findByUserName(String username);

  List<User> findByUserNameSingle(String username);

  List<User> findByRealName(String realname);

  List<User> findAdmin();

  List<User> findByPhone(String phone);

  List<User> findByEmail(String email);

  List<User> findByPhoneSingle(String phone);

  List<User> findByEmailSingle(String email);

  List<User> checkPassword(String identify, String password);
}
