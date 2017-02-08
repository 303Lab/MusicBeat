package com.musicbeat.web.service;

import com.musicbeat.web.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author windawings
 * @time.creation 2017/1/5
 * @version 1.0.0
 * @since 1.0.0
 */

public interface UserService{

  Logger logger = Logger.getLogger(UserService.class);

  void add(User user);

  void update(User user);

  void delete(Integer id);

  List<User> findById(Integer id);

  List<User> findByUserName(String username, Boolean like);

  List<User> findByRealName(String realname, Boolean like);

  List<User> findAdmin();

  List<User> findByPhone(String phone, Boolean like);

  List<User> findByEmail(String email, Boolean like);

  List<User> checkPassword(String identify, String password);
}
