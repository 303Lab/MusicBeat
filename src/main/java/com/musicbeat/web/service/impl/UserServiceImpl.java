package com.musicbeat.web.service.impl;

import com.musicbeat.web.mapper.UserMapper;
import com.musicbeat.web.model.User;
import com.musicbeat.web.service.UserService;

import com.musicbeat.web.utils.RegexValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * 用户服务接口实现类
 * Created by windawings on 2017/1/5
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

  private UserMapper userMapper;

  private static Logger logger = Logger.getLogger(UserMapper.class.getSimpleName());

  @Autowired
  public void setUserMapper(UserMapper addMapper) {
    this.userMapper = addMapper;
  }

  @Override
  public void add(User user) {
    userMapper.insert(user);
  }

  @Override
  public void update(User user) {
    userMapper.updateByPrimaryKeySelective(user);
  }

  @Override
  public void delete(Integer id) {
    userMapper.deleteByPrimaryKey(id);
  }

  @Override
  public List<User> findById(Integer id) { return userMapper.selectByPrimaryKey(id);}

  @Override
  public List<User> findByUserName(String username) { return userMapper.selectByUserName(username);}

  @Override
  public List<User> findByUserNameSingle(String username) {
    return userMapper.selectByUserNameSingle(username);
  }

  @Override
  public List<User> findByRealName(String realname) {
    return userMapper.selectByRealName(realname);
  }

  @Override
  public List<User> findAdmin() {
    return userMapper.selectAdmin();
  }

  @Override
  public List<User> findByPhone(String phone) {
    return userMapper.selectByPhone(phone);
  }

  @Override
  public List<User> findByPhoneSingle(String phone) {return userMapper.selectByPhoneSingle(phone);}

  @Override
  public List<User> findByEmail(String email) {return userMapper.selectByEmail(email);}

  @Override
  public List<User> findByEmailSingle(String email) {return userMapper.selectByEmailSingle(email);}

  @Override
  public List<User> checkPassword(String identify, String password) {
    List<User> users = null;

    if (RegexValidateUtil.checkEmail(identify)) {
      users = findByEmailSingle(identify);
    } else if (RegexValidateUtil.checkMobileNumber(identify)) {
      users = findByPhoneSingle(identify);
    } else {
      users = findByUserNameSingle(identify);
    }

    /*如果输入的是ID*/
    if ((users == null || users.isEmpty()) && RegexValidateUtil.checkNumeric(identify)) {
      try {
        users = findById(Integer.parseInt(identify));
      } catch (NumberFormatException e) {
        logger.warning(e.getMessage());
      }
    }

    if (users == null || users.isEmpty()) {
      return null;
    }

    if (users.get(0).getPassword().equals(password)) {
      return users;
    }
    return null;
  }
}
