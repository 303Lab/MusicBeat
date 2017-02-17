package com.musicbeat.web.service.impl;

import com.musicbeat.web.mapper.UserMapper;
import com.musicbeat.web.model.User;
import com.musicbeat.web.service.EmailService;
import com.musicbeat.web.service.UserService;

import com.musicbeat.web.utils.EncryptUtil;
import com.musicbeat.web.utils.RandomUtil;
import com.musicbeat.web.utils.RegexValidateUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.musicbeat.web.service.EmailService.MAIL_ACTIVE_CODE_LENGTH;

/**
 * 用户服务接口实现类
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 2017/1/5
 * @since 1.0.0
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private EmailService emailService;

    @Override
    public boolean register(User user) {
        String random = RandomUtil.generateMixString(MAIL_ACTIVE_CODE_LENGTH);

        // 密码哈希
        String hashPassword = EncryptUtil.SHA256(random);
        user.setPassword(hashPassword);

        // 默认用户名
        if (user.getUsername().isEmpty()) {
            user.setUsername(user.getEmail().split("@")[0]);
        }

        // 发送邮件
        return emailService.sendActiveEmail(user, random) && this.add(user);
    }

    @Override
    public boolean add(User user) {
        return userMapper.insertSelective(user) == 1;
    }

    @Override
    public boolean update(User user) {
        return userMapper.updateByPrimaryKeySelective(user) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return userMapper.deleteByPrimaryKey(id) == 1;
    }

    @Override
    public List<User> findById(Integer id) { return userMapper.selectByPrimaryKey(id);}

    @Override
    public List<User> findByUserName(String username, Boolean like) {
        return userMapper.selectByUserName(
          username,
          like
        );
    }

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
        try {
            List<User> users;

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

            if (password.length() != EncryptUtil.SHA256LENGTH) {
                password = EncryptUtil.SHA256(password);
            }

            if (users.get(0).getPassword().equals(password)) {
                return users;
            }
        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }

        return null;
    }
}
