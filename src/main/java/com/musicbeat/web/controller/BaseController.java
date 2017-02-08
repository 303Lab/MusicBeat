package com.musicbeat.web.controller;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 基础控制器
 *
 * @author windawings
 * @time.creation 2017/02/03 15:33
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller("BaseController")
@RequestMapping(value = "/api")
public class BaseController {
  protected Logger logger = Logger.getLogger(this.getClass());
  protected HttpServletRequest request;
  protected HttpServletResponse response;
  protected HttpSession session;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }
}
