package com.musicbeat.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.musicbeat.web.model.User;
import com.musicbeat.web.model.cache.RetrieveCache;
import com.musicbeat.web.service.RedisService;
import com.musicbeat.web.service.UserService;
import org.mybatis.caches.redis.RedisCache;
import org.springframework.cache.support.NullValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import static com.musicbeat.web.model.constant.Constants.AUTH_ROLE;
import static com.musicbeat.web.model.constant.Constants.HTTP_UTF8;
import static com.musicbeat.web.model.constant.Constants.LOG_EMAIL;
import static com.musicbeat.web.model.constant.Constants.LOG_NEW_PASSWORD;
import static com.musicbeat.web.model.constant.Constants.LOG_PASSWORD;
import static com.musicbeat.web.model.constant.Constants.LOG_USER;
import static com.musicbeat.web.model.constant.Constants.REQUEST_EMAIL_JSON;
import static com.musicbeat.web.model.constant.Constants.REQUEST_PASSWORD_JSON;
import static com.musicbeat.web.model.constant.Constants.REQUEST_USERNAME_JSON;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_CREDENTIAL;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_EXCEPTION;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_LOGOFF_USER_BLANK;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_REGISTER;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_REGISTER_DUPLICATE_EMAIL;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_REGISTER_DUPLICATE_USERNAME;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_RETRIEVE;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_RETRIEVE_NONE;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_RETRIEVE_TIMEOUT;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_FAIL;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_MESSAGE;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_STATUS;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_SUCCESS;
import static com.musicbeat.web.model.constant.Constants.RETRIEVE_EXPIRE_TIME;
import static com.musicbeat.web.model.constant.Constants.SESSION_USER;
import static com.musicbeat.web.utils.ModelConvertUtil.convert2ViewModelIgnoreNull;
import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_CONFLICT;
import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

/**
 * 登陆控制器类
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 2017/01/20 17:13
 * @since 1.0.0
 */
@Controller("AuthController")
public class AuthController extends BaseController {

    @Resource
    private UserService userService;

    /**
     * 用户登录Controller
     *
     * @param jsonObject the json object
     * @return the model and view
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ModelMap login(@RequestBody JSONObject jsonObject) {

        ModelMap model = new ModelMap();
        JSONObject logObj = new JSONObject();

        try {
            // 如果用户已登录，清除登陆信息
            if (session.getAttribute(SESSION_USER) != null) {
                session.removeAttribute(SESSION_USER);
            }

            // 解析Json对象
            String identify = URLDecoder.decode(jsonObject.getString(REQUEST_USERNAME_JSON), HTTP_UTF8);
            String password = URLDecoder.decode(jsonObject.getString(REQUEST_PASSWORD_JSON), HTTP_UTF8);

            // 放置日志记录对象
            logObj.put(LOG_USER, identify);
            logObj.put(LOG_PASSWORD, password);

            // 检验用户名和密码
            List<User> users = userService.checkPassword(identify, password);

            if (users != null) {
                User user = users.get(0);
                JSONObject userViewModel = convert2ViewModelIgnoreNull(user);

                // 返回视图
                model.put(SESSION_USER, userViewModel);
                model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
                model.put(AUTH_ROLE, user.getPrivilege());

                // 存入Session
                session.setAttribute(SESSION_USER, user);

                logger.info(logObj.toJSONString() + " Log in");

            } else {
                model.put(RESPONSE_STATUS, RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_CREDENTIAL);
                response.setStatus(SC_UNAUTHORIZED);

                logger.warn(logObj.toJSONString() + " Log failed");
            }
        } catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(logObj.toJSONString() + " Log error");
            logger.error(e, e.fillInStackTrace());
        }
        return model;
    }

    /**
     * 用户注销
     *
     * @return the model map
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public @ResponseBody ModelMap logout() {
        ModelMap model = new ModelMap();
        JSONObject logObj = new JSONObject();

        try {
            // 如果用户已登录，清除登陆信息
            User user = (User) session.getAttribute(SESSION_USER);

            if (user != null) {
                logObj.put(LOG_USER, user.getUsername());
                session.removeAttribute(SESSION_USER);

                // 返回视图
                model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);

                // 日志记录
                logger.info(logObj.toJSONString() + " Log out");
            }
            else{
                model.put(RESPONSE_STATUS, RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_LOGOFF_USER_BLANK);
                response.setStatus(SC_BAD_REQUEST);

                logger.info(logObj.toJSONString() + " Logoff nothing");
            }
        }catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(logObj.toJSONString() + " LogOut Error");
            logger.error(e, e.fillInStackTrace());
        }

        return model;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Callable<ModelMap> register(@RequestBody JSONObject jsonObject) {

        JSONObject logObj = new JSONObject();
        ModelMap model = new ModelMap();

        try {
            // 解析Json对象
            String email = URLDecoder.decode(jsonObject.getString(REQUEST_EMAIL_JSON), HTTP_UTF8);
            String username = URLDecoder.decode(jsonObject.getString(REQUEST_USERNAME_JSON), HTTP_UTF8);

            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPrivilege("user");
            user.setPicture("images/user.png");

            List<User> emails = userService.findByEmail(email, false);
            List<User> users;

            if (username != null && !username.isEmpty()) {
                users = userService.findByUserName(username, false);
            } else {
                // 默认用户名
                user.setUsername(user.getEmail().split("@")[0]);
                users = userService.findByUserName(username, false);
            }

            logObj.put(LOG_EMAIL, email);
            logObj.put(LOG_USER, username);

            if (!emails.isEmpty()) {

                model.put(RESPONSE_STATUS, RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_REGISTER_DUPLICATE_EMAIL);
                logger.info(logObj.toJSONString() + ", Register Error - Duplicate Email");
                response.setStatus(SC_CONFLICT);

            } else if (users == null || !users.isEmpty()) {

                model.put(RESPONSE_STATUS, RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_REGISTER_DUPLICATE_USERNAME);
                logger.info(logObj.toJSONString() + ", Register Error - Duplicate UserName");
                response.setStatus(SC_CONFLICT);

            } else {

                if (userService.register(user)) {
                    model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
                } else {
                    model.put(RESPONSE_STATUS, RESPONSE_FAIL);
                    model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_REGISTER);
                    response.setStatus(SC_INTERNAL_SERVER_ERROR);
                }
            }

        } catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(logObj.toJSONString() + ", Register Error");
            logger.error(e, e.fillInStackTrace());
        }

        return () -> model;
    }

    @RequestMapping(value = "/retrieve", method = RequestMethod.POST)
    public @ResponseBody Callable<ModelMap> retrieve(@RequestBody JSONObject jsonObject) {
        JSONObject logObj = new JSONObject();
        ModelMap model = new ModelMap();

        try {
            // 解析Json对象
            String email = URLDecoder.decode(jsonObject.getString(REQUEST_EMAIL_JSON), HTTP_UTF8);

            User user = new User();
            user.setEmail(email);
            logObj.put(LOG_EMAIL, email);

            String url = request.getScheme()
                         + "://"
                         + request.getServerName()
                         + ":"
                         + request.getServerPort()
                         + request.getContextPath();

            String result = userService.retrieve(user, url);

            if (result.equals(RESPONSE_SUCCESS)) {
                model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
            } else {
                model.put(RESPONSE_STATUS, RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, result);
                response.setStatus(SC_INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_RETRIEVE);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(logObj.toJSONString() + ", Retrieve Error");
            logger.error(e, e.fillInStackTrace());
        }

        return () -> model;
    }

    @RequestMapping(value = "/retrieve", method = RequestMethod.GET)
    public ModelAndView retrieve(@RequestParam("u") String email, @RequestParam("c") String code) {

        ModelAndView mav = new ModelAndView();
        ModelMap model = mav.getModelMap();
        JSONObject logObj = new JSONObject();

        try {
            if (email.isEmpty() || code.isEmpty()) {
                throw new NullPointerException();
            }

            User user = new User();
            String base64String = URLDecoder.decode(email, HTTP_UTF8);
            String emailString = new String(Base64Utils.decodeFromUrlSafeString(base64String), HTTP_UTF8);
            user.setEmail(emailString);
            logObj.put(LOG_EMAIL, email);

            if (userService.retrieveVerify(user, code)) {

                mav.setViewName("change");

            } else {
                throw new Exception();
            }

        } catch (Exception e) {

            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_RETRIEVE);

            response.setStatus(SC_NOT_FOUND);
            mav.setStatus(HttpStatus.NOT_FOUND);

            logger.error(logObj.toJSONString() + ", Get Retrieve Page Error");
            logger.error(e, e.fillInStackTrace());
        }

        return mav;
    }

    @RequestMapping(value = "/retrieveChange", method = RequestMethod.POST)
    public @ResponseBody ModelMap retrieveChange(@RequestParam("u") String email, @RequestParam("c") String code, @RequestBody JSONObject jsonObject) {

        ModelMap model = new ModelMap();
        JSONObject logObj = new JSONObject();

        try {
            if (email.isEmpty() || code.isEmpty()) {
                throw new NullPointerException();
            }

            // 解析Json对象
            String newPassword = URLDecoder.decode(jsonObject.getString(REQUEST_PASSWORD_JSON), HTTP_UTF8);

            User user = new User();
            String base64String = URLDecoder.decode(email, HTTP_UTF8);
            String emailString = new String(Base64Utils.decodeFromUrlSafeString(base64String), HTTP_UTF8);
            user.setEmail(emailString);
            logObj.put(LOG_EMAIL, email);
            logObj.put(LOG_NEW_PASSWORD, newPassword);


            if (userService.retrieveWithoutTimeCheck(user, code) && userService.changePassword(user, newPassword)) {

                model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
                logger.info(logObj.toJSONString() + ", Retrieve Change Password Success");

            } else {
                throw new Exception();
            }

        } catch (NullPointerException e) {

            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_RETRIEVE_NONE);

            response.setStatus(SC_NOT_FOUND);

            logger.error(logObj.toJSONString() + ", Retrieve Change Password None Params");
            logger.error(e, e.fillInStackTrace());

        } catch (Exception e) {

            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_RETRIEVE);

            response.setStatus(SC_NOT_FOUND);

            logger.error(logObj.toJSONString() + ", Retrieve Change Password Error");
            logger.error(e, e.fillInStackTrace());
        }

        return model;
    }
}
