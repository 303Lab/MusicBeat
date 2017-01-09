package com.musicbeat.web.controller;

import com.musicbeat.web.model.User;
import com.musicbeat.web.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户控制器
 * Created by windawings on 2017/1/5 0005.
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/user")
public class UserController {
  @Resource
  private UserService userService;

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ModelAndView login(
    @RequestParam(value = "username") String identify,
    @RequestParam(value = "password") String password
  ) {
    List<User> users = userService.checkPassword(identify, password);
    if (users != null) {
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.addObject("userInfo", users.get(0));
      return modelAndView;
    }

    return null;
  }
}
