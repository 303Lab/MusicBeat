package com.musicbeat.web.controller;

import com.musicbeat.web.model.User;
import com.musicbeat.web.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户控制器
 * Created by windawings on 2017/1/5 0005.
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/user")
public class UserController{
  private static Logger logger = Logger.getLogger(UserController.class);

  @Resource
  private UserService userService;

  /*用户登录Controller*/
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ModelAndView login(HttpServletRequest request) {
    ModelAndView modelAndView = new ModelAndView();
    try{
      String identify = request.getParameter("username");
      String password = request.getParameter("password");
      List<User> users = userService.checkPassword(identify, password);

      if (users != null) {
        modelAndView.addObject("userinfo", users.get(0));
        modelAndView.addObject("status", "success");
        return modelAndView;
      }
    }catch (Exception e) {
      modelAndView.addObject("status", "fail");
      logger.error(e.getMessage());
    }
    return modelAndView;
  }
}
