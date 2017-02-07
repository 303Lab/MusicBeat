package com.musicbeat.web.service.impl;

import com.musicbeat.web.mapper.UserMapper;
import com.musicbeat.web.model.User;
import com.musicbeat.web.service.UserService;

import com.musicbeat.web.utils.RegexValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务接口实现类
 *
 * @author windawings
 * @time.creation 2017/1/5
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("UserService")
public class UserServiceImpl implements UserService{

  private UserMapper userMapper;

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
  public List<User> findByUserName(String username, Boolean like) { return userMapper.selectByUserName(username, like);}

  @Override
  public List<User> findByRealName(String realname, Boolean like) {
    return userMapper.selectByRealName(realname, like);
  }

  @Override
  public List<User> findAdmin() {
    return userMapper.selectAdmin();
  }

  @Override
  public List<User> findByPhone(String phone, Boolean like) {
    return userMapper.selectByPhone(phone, like);
  }

  @Override
  public List<User> findByEmail(String email, Boolean like) {return userMapper.selectByEmail(email, like);}

  @Override
  public List<User> checkPassword(String identify, String password) {
    List<User> users = null;

    if (RegexValidateUtil.checkEmail(identify)) {
      users = findByEmail(identify, false);
    } else if (RegexValidateUtil.checkMobileNumber(identify)) {
      users = findByPhone(identify, false);
    } else {
      users = findByUserName(identify, false);
    }

    /*如果输入的是ID*/
    if ((users == null || users.isEmpty()) && RegexValidateUtil.checkNumeric(identify)) {
      try {
        users = findById(Integer.parseInt(identify));
      } catch (NumberFormatException e) {
        logger.error(e.getMessage());
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
