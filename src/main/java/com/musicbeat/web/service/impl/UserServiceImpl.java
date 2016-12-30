package com.musicbeat.web.service.impl;

import com.musicbeat.web.model.User;
import com.musicbeat.web.service.UserService;
import com.musicbeat.web.dao.UserDao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

  @Resource
  private UserDao userDao;

  @Override
  public User getUserById(Long userId) {
    return userDao.selectUserById(userId);
  }

  @Override
  public User getUserByPhoneOrEmail(String emailOrPhone, Short state) {
    return userDao.selectUserByPhoneOrEmail(emailOrPhone, state);
  }

  @Override
  public List<User> getAllUser() {
    return userDao.selectAllUser();
  }
}
