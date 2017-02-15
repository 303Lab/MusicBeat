package com.musicbeat.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.musicbeat.web.model.User;
import com.musicbeat.web.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.util.List;

import static com.musicbeat.web.model.constant.Constants.AUTH_ROLE;
import static com.musicbeat.web.model.constant.Constants.HTTP_UTF8;
import static com.musicbeat.web.model.constant.Constants.LOG_PASSWORD;
import static com.musicbeat.web.model.constant.Constants.LOG_USER;
import static com.musicbeat.web.model.constant.Constants.REQUEST_PASSWORD_JSON;
import static com.musicbeat.web.model.constant.Constants.REQUEST_USERNAME_JSON;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_CREDENTIAL;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_EXCEPTION;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_FAIL;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_MESSAGE;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_MESSAGE_SUCCESS;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_STATUS;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_SUCCESS;
import static com.musicbeat.web.model.constant.Constants.SESSION_USER;
import static com.musicbeat.web.utils.ModelConvertUtil.convert2ViewModelIgnoreNull;
import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

/**
 * 登陆控制器类
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 2017/01/20 17:13
 * @since 1.0.0
 */
@Controller("LoginController")
public class LoginController extends BaseController {

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
                model.put(RESPONSE_MESSAGE, RESPONSE_MESSAGE_SUCCESS);

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
            }

            // 返回视图
            model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
            model.put(RESPONSE_MESSAGE, RESPONSE_MESSAGE_SUCCESS);

            // 日志记录
            logger.info(logObj.toJSONString() + " Log out");

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
    public @ResponseBody ModelMap register(@RequestBody JSONObject jsonObject) {

        ModelMap model = new ModelMap();
        JSONObject logObj = new JSONObject();

        try {

        }catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(logObj.toJSONString() + " Register Error");
            logger.error(e, e.fillInStackTrace());
        }

        return model;
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    public ModelAndView changePassword() {
        try {
            return new ModelAndView("userChgPwd");
        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }
        return null;
    }

    @RequestMapping(value = "/forget", method = RequestMethod.GET)
    public ModelAndView forget() {
        return null;
    }
}
