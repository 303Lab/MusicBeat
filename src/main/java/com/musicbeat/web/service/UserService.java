package com.musicbeat.web.service;

import com.musicbeat.web.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 2017/1/5
 * @since 1.0.0
 */

public interface UserService {

    Logger logger = Logger.getLogger(UserService.class);

    boolean add(User user);

    boolean update(User user);

    boolean delete(Integer id);

    boolean deleteByUserName(String username);

    boolean deleteByEmail(String email);

    List<User> findById(Integer id);

    List<User> findByUserName(String username, Boolean like);

    List<User> findByRealName(String realname, Boolean like);

    List<User> findAdmin();

    List<User> findByPhone(String phone, Boolean like);

    List<User> findByEmail(String email, Boolean like);

    List<User> checkPassword(String identify, String password);

    boolean register(User user);

    String retrieve(User user, String url);

    boolean retrieveWithoutTimeCheck(User user, String code);

    boolean retrieveVerify(User user, String code);

    boolean changePassword(User user, String newPassword);
}
