package com.musicbeat.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.musicbeat.web.model.User;
import com.musicbeat.web.model.viewmodel.UserViewModel;
import com.musicbeat.web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.musicbeat.web.model.constant.Constants.Access_Token;
import static com.musicbeat.web.model.constant.Constants.Auth_Role;
import static com.musicbeat.web.model.constant.Constants.REQUEST_PASSWORD;
import static com.musicbeat.web.model.constant.Constants.REQUEST_USERNAME;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_CREDENTIAL;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_EXCEPTION;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_FAIL;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_MESSAGE;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_MESSAGE_SUCCESS;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_STATUS;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_SUCCESS;
import static com.musicbeat.web.model.constant.Constants.SESSION_USER;
import static com.musicbeat.web.utils.ModelConvertUtil.Convert2ViewModel;

/**
 * 登陆控制器类
 *
 * @author windawings
 * @time.creation 2017/01/20 17:13
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller("LoginController")
public class LoginController extends BaseController{

  @Resource
  private UserService userService;

  /**
   * 用户登录Controller
   *
   * @return the model and view
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public @ResponseBody
  ModelMap Login() {
    ModelMap model = new ModelMap();
    JSONObject logObj = new JSONObject();

    try {
      /*如果用户已登录，清除登陆信息*/
      if (session.getAttribute(SESSION_USER) != null) {
        session.removeAttribute(SESSION_USER);
        session.removeAttribute(Access_Token);
      }

      String identify = request.getParameter(REQUEST_USERNAME);
      String password = request.getParameter(REQUEST_PASSWORD);

      logObj.put("user", identify);
      logObj.put("pass", password);

      /*检验用户名和密码*/
      List<User> users = userService.checkPassword(identify, password);

      if (users != null) {
        User user = users.get(0);
        UserViewModel userViewModel = (UserViewModel) Convert2ViewModel(user);

        /*返回视图*/
        model.put(SESSION_USER, userViewModel);
        model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
        model.put(Access_Token, "bear test string from ModelAndView");
        model.put(Auth_Role, user.getPrivilege());
        model.put(RESPONSE_MESSAGE, RESPONSE_MESSAGE_SUCCESS);

        /*存入Session*/
        session.setAttribute(SESSION_USER, user);
        session.setAttribute(Access_Token, "bear test string from SessionCache");

        logger.info(logObj.toJSONString() + " Log in");

      } else {
        model.put(RESPONSE_STATUS, RESPONSE_FAIL);
        model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_CREDENTIAL);
        logger.warn(logObj.toJSONString() + " Log failed");
        response.setStatus(401);
      }
    } catch (Exception e) {
      model.put(RESPONSE_STATUS, RESPONSE_FAIL);
      model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
      logger.error(logObj.toJSONString() + " Log error");
      logger.error(e, e.fillInStackTrace());
    }
    return model;
  }

  @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
  public ModelAndView ChangePassword(HttpServletRequest request) {
    try{
      return new ModelAndView("userChgPwd");
    }catch (Exception e) {
      logger.error(e, e.fillInStackTrace());
    }
    return null;
  }

  @RequestMapping(value = "/forget", method = RequestMethod.GET)
  public ModelAndView Forget(HttpServletRequest request) {
    return null;
  }
}
