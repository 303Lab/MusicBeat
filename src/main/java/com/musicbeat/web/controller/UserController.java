package com.musicbeat.web.controller;

import com.musicbeat.web.model.User;
import com.musicbeat.web.model.viewmodel.UserViewModel;
import com.musicbeat.web.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.musicbeat.web.model.constant.RequestParamsConstant.Password;
import static com.musicbeat.web.model.constant.RequestParamsConstant.UserName;
import static com.musicbeat.web.model.constant.SessionAttributesConstant.UserInfo;
import static com.musicbeat.web.model.constant.StatusConstant.Fail;
import static com.musicbeat.web.model.constant.StatusConstant.Status;
import static com.musicbeat.web.model.constant.StatusConstant.Success;
import static com.musicbeat.web.utils.ModelConvertUtil.Convert2ViewModel;

/**
 * 用户控制器类
 *
 * @author windawings
 * @createTime 2017/01/20 17:13
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/user")
public class UserController {
  private static Logger logger = Logger.getLogger(UserController.class);

  @Resource
  private UserService userService;

  /**
   * 用户登录Controller
   *
   * @param request the request
   * @return the model and view
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ModelAndView Login(HttpServletRequest request) {
    HttpSession session = request.getSession();
    ModelAndView modelAndView = new ModelAndView();
    try {
      /*如果用户已登录，清除登陆信息*/
      if (session.getAttribute(UserInfo) != null) {
        session.removeAttribute(UserInfo);
      }

      String identify = request.getParameter(UserName);
      String password = request.getParameter(Password);

      /*检验用户名和密码*/
      List<User> users = userService.checkPassword(identify, password);

      if (users != null) {
        User user = users.get(0);
        UserViewModel userViewModel = (UserViewModel) Convert2ViewModel(user);

        /*返回视图*/
        modelAndView.addObject(UserInfo, userViewModel);
        modelAndView.addObject(Status, Success);

        /*存入Session*/
        session.setAttribute(UserInfo, user);

      } else {
        modelAndView.addObject(Status, Fail);
      }
    } catch (Exception e) {
      modelAndView.addObject(Status, Fail);
      logger.error(e, e.fillInStackTrace());
    }
    return modelAndView;
  }

  @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
  public ModelAndView ChangePassword(HttpServletRequest request) {
    return null;
  }

  @RequestMapping(value = "/forget", method = RequestMethod.POST)
  public ModelAndView Forget(HttpServletRequest request) {
    return null;
  }
}
