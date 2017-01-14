package com.musicbeat.web.controller;

import com.alibaba.fastjson.JSON;
import com.musicbeat.web.utils.JUnit4ClassRunner;

import org.apache.log4j.Logger;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * UserController Tester.
 *
 * @author windawings
 * @version 1.0
 * @since <pre>1/9/2017</pre>
 */
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:config/spring/*.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserControllerTest {

  private static Logger logger = Logger.getLogger(UserControllerTest.class);

  private MockMvc mockMvc;

  @Autowired
  private UserController userController;

  @Before
  public void before() throws Exception {
    this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: login(HttpServletRequest request)
   */
  @Test
  public void testLogin() throws Exception {
    try{
      ResultActions resultActions =
        this.mockMvc.perform(MockMvcRequestBuilders
                               .post("/user/login/")
                               .param("username", "windawings")
                               .param("password", "123")
                               .accept(MediaType.APPLICATION_JSON));
      MvcResult mvcResult = resultActions.andExpect(status().isOk())
                                         .andExpect(view().name("user/login"))
                                         .andDo(print())
                                         .andReturn();
      logger.debug(
        "\"status\":"
        + JSON.toJSONString(mvcResult.getModelAndView().getModel().get("status"))
        + ", "
        + "\"userinfo\":"
        + JSON.toJSONString(mvcResult.getModelAndView().getModel().get("userinfo")));
    }catch (Exception e) {
      logger.error(e.getMessage());
    }

  }
} 
