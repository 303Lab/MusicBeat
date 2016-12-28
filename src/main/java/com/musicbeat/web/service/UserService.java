package com.musicbeat.web.service;

import com.musicbeat.web.model.User;

import java.util.List;

public interface UserService {

  List<User> getAllUser();

  User getUserByPhoneOrEmail(String emailOrPhone, Short state);

  User getUserById(Long userId);
}
