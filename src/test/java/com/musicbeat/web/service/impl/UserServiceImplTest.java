package com.musicbeat.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.musicbeat.web.model.User;
import com.musicbeat.web.service.UserService;
import com.musicbeat.web.utils.JUnit4ClassRunner;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserServiceImpl Tester.
 *
 * @author windawings
 * @time.creation 1/8/2017
 * @version 1.0.0
 * @since 1.0.0
 */
@RunWith(JUnit4ClassRunner.class)//表示继承了JUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"}) //指定Spring配置文件的位置
//很多情况下单元测试离不开事务，下面的注解指明使用的事务管理器
//如果defaultRollback为true，测试运行结束后，默认回滚事务，不影响数据库
@Rollback(true)
@Transactional(transactionManager = "transactionManager")
public class UserServiceImplTest {
  private static Logger logger = Logger.getLogger(UserServiceImplTest.class);

  @Resource
  private UserService userService;

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: add(User user)
   */
  @Test
  public void testAdd() throws Exception {
    User user = new User(
      null,
      "test",
      "123",
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      "222222222@qq.com",
      null,
      "user",
      null,
      null
    );
    userService.add(user);
    logger.info(JSON.toJSONString(user));
  }

  /**
   * Method: update(User user)
   */
  @Test
  public void testUpdate() throws Exception {
    User user = new User(
      1,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      "windaawings@gmail.com",
      null,
      null,
      null
    );
    userService.update(user);
    logger.info(JSON.toJSONString(user));
  }

  /**
   * Method: delete(Integer id)
   */
  @Test
  public void testDelete() throws Exception {
    userService.delete(2);
    logger.info("success delete id 2");
  }

  /**
   * Method: findById(Integer id)
   */
  @Test
  public void testFindById() throws Exception {
    List<User> result = userService.findById(2);
    logger.info(JSON.toJSONString(result));
  }

  /**
   * Method: findByUserName(String name, Boolean like)
   */
  @Test
  public void testFindByUserName() throws Exception {
    List<User> result = userService.findByUserName("windawings", true);
    logger.info(JSON.toJSONString(result));
    result = userService.findByUserName("windawings", false);
    logger.info(JSON.toJSONString(result));
  }

  /**
   * Method: findByRealName(String realname)
   */
  @Test
  public void testFindByRealName() throws Exception {
    List<User> result = userService.findByRealName("www", true);
    logger.info(JSON.toJSONString(result));
  }

  /**
   * Method: findAdmin()
   */
  @Test
  public void testFindAdmin() throws Exception {
    List<User> result = userService.findAdmin();
    logger.info(JSON.toJSONString(result));
  }

  /**
   * Method: findByPhone(String phone)
   */
  @Test
  public void testFindByPhone() throws Exception {
    List<User> result = userService.findByPhone("13066666666", false);
    logger.info(JSON.toJSONString(result));
  }

  /**
   * Method: findByEmail(String email)
   */
  @Test
  public void testFindByEmail() throws Exception {
    List<User> result = userService.findByEmail("windawings@foxmail.com", true);
    logger.info(JSON.toJSONString(result));
  }

}