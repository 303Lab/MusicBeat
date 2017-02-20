package com.musicbeat.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.musicbeat.web.mapper.UserMapper;
import com.musicbeat.web.model.User;
import com.musicbeat.web.model.cache.RetrieveCache;
import com.musicbeat.web.service.EmailService;
import com.musicbeat.web.service.RedisService;
import com.musicbeat.web.service.UserService;

import com.musicbeat.web.utils.EncryptUtil;
import com.musicbeat.web.utils.RandomUtil;
import com.musicbeat.web.utils.RegexValidateUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.annotation.Resource;
import java.util.List;

import static com.musicbeat.web.model.constant.Constants.HTTP_UTF8;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_EXCEPTION;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_RETRIEVE_NONE_USER;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_RETRIEVE_NOW_EXPIRE;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_SUCCESS;
import static com.musicbeat.web.model.constant.Constants.RETRIEVE_EXPIRE_TIME;
import static com.musicbeat.web.model.constant.Constants.USERSERVICE_ERROR_DELETE;
import static com.musicbeat.web.model.constant.Constants.USERSERVICE_ERROR_INSERT;
import static com.musicbeat.web.model.constant.Constants.USERSERVICE_ERROR_RETRIEVE;
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

    @Resource
    private RedisService redisService;

    @Override
    public boolean register(User user) {
        try {
            String random = RandomUtil.generateMixString(MAIL_ACTIVE_CODE_LENGTH);

            // 密码哈希
            String hashPassword = EncryptUtil.SHA256(random);
            user.setPassword(hashPassword);

            // 默认用户名
            if (user.getUsername().isEmpty()) {
                user.setUsername(user.getEmail().split("@")[0]);
            }

            if (this.add(user)) {
                if (emailService.sendActiveEmail(user, random)) {
                    return true;
                } else if(this.deleteByUserName(user.getUsername())) {
                    return false;
                } else {
                    throw new Exception(USERSERVICE_ERROR_DELETE);
                }
            } else {
                throw new Exception(USERSERVICE_ERROR_INSERT);
            }
        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }

        return false;
    }

    @Override
    public String retrieve(User user, String url) {
        try {
            // 用户未注册
            List<User> emails = this.findByEmail(user.getEmail(), false);
            if (emails.isEmpty()) return user.getEmail() + RESPONSE_ERROR_RETRIEVE_NONE_USER;


            RetrieveCache cache = redisService.findRetrieveCode(user);

            // 判断是否30分钟内多次发送
            if (cache != null) {

                return RESPONSE_ERROR_RETRIEVE_NOW_EXPIRE;
            }

            List<User> users = this.findByEmail(user.getEmail(), false);

            if (users.isEmpty()) {
                return user.getEmail() + RESPONSE_ERROR_RETRIEVE_NONE_USER;
            }

            user = users.get(0);

            // 生成找回代码
            String randomString = RandomUtil.generateString(32);

            JSONObject object = new JSONObject();
            object.put("user", user.toString());
            object.put("random",randomString);
            String random = EncryptUtil.SHA512(object.toJSONString());

            random = (
              random.substring(0, 8)
              + random.substring(31, 39)
              + random.substring(63, 71)
              + random.substring(95, 103)
              + random.substring(119, 127)
            ).toUpperCase();

            byte[] emailBytes = user.getEmail().getBytes(HTTP_UTF8);
            String base64String = Base64Utils.encodeToUrlSafeString(emailBytes);


            url = url + "/api/retrieve?u=" + base64String +"&c=" + random;

            cache = new RetrieveCache(user.getEmail(), random);

            if (redisService.addRetrieveCode(cache)) {
                if (emailService.sendRetrieveEmail(user, url)){
                    return RESPONSE_SUCCESS;
                } else {
                    redisService.deleteRetrieveCode(user);
                    throw new Exception(USERSERVICE_ERROR_RETRIEVE);
                }
            } else {
                throw new Exception(USERSERVICE_ERROR_RETRIEVE);
            }
        }catch (Exception e) {
            logger.error(e, e.fillInStackTrace());

            return RESPONSE_ERROR_EXCEPTION;
        }
    }

    @Override
    public boolean retrieveWithoutTimeCheck(User user, String code) {

        try{

            RetrieveCache cache = redisService.findRetrieveCode(user);

            if (cache != null) {
                String verifyCode = cache.getRandom();

                if (verifyCode.equals(code) && redisService.deleteRetrieveCode(user)){
                    return true;
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }

        return false;
    }

    @Override
    public boolean changePassword(User user, String newPassword) {
        try {

            List<User> users = this.findByEmail(user.getEmail(), false);

            if (!users.isEmpty()) {

                if (newPassword.length() != EncryptUtil.SHA256LENGTH) {
                    newPassword = EncryptUtil.SHA256(newPassword);
                }

                user = users.get(0);
                user.setPassword(newPassword);


                return this.update(user);
            }

        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }

        return false;
    }

    @Override
    public boolean retrieveVerify(User user, String code) {

        try{

            RetrieveCache cache = redisService.findRetrieveCode(user);

            if (cache != null) {
                String verifyCode = cache.getRandom();

                if (verifyCode.equals(code)){
                    return true;
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }

        return false;
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
    public boolean deleteByUserName(String username) {
        return userMapper.deleteByUserName(username) == 1;
    }

    @Override
    public boolean deleteByEmail(String email) {
        return userMapper.deleteByEmail(email) == 1;
    }

    @Override
    public List<User> findById(Integer id) { return userMapper.selectByPrimaryKey(id);}

    @Override
    public List<User> findByUserName(String username, Boolean like) {
        return userMapper.selectByUserName(username, like);
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
