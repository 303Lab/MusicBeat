package com.musicbeat.web.controller;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 基础控制器
 *
 * @author windawings
 * @time.creation 2017/02/03 15:33
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@Scope(value = "prototype")
@RequestMapping(value = "/api")
public class BaseController {
  protected Logger logger = Logger.getLogger(this.getClass());
}
