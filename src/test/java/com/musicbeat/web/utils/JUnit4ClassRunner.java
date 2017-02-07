package com.musicbeat.web.utils;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

/**
 * JUnit加载Log配置文件
 * @author windawings
 * @time.creation 2017/1/8
 * @version 1.0.0
 * @since 1.0.0
 */
public class JUnit4ClassRunner extends SpringJUnit4ClassRunner {
  static {
    try {
      Log4jConfigurer.initLogging("classpath:config/log4j.properties");
    } catch (FileNotFoundException ex) {
      System.err.println("Cannot Initialize log4j");
    }
  }

  public JUnit4ClassRunner(Class<?> clazz) throws InitializationError {
    super(clazz);
  }
}
