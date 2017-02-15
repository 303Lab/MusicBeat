package com.musicbeat.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.musicbeat.web.utils.JUnit4ClassRunner;

import org.apache.log4j.Logger;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.musicbeat.web.model.constant.Constants.HTTP_UTF8;
import static com.musicbeat.web.model.constant.Constants.REQUEST_PASSWORD_JSON;
import static com.musicbeat.web.model.constant.Constants.REQUEST_TYPE_JSON;
import static com.musicbeat.web.model.constant.Constants.REQUEST_USERNAME_JSON;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_STATUS;
import static com.musicbeat.web.model.constant.Constants.SESSION_USER;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * UserController Tester.
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 1/9/2017
 * @since 1.0.0
 */
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"})
@Rollback(true)
@Transactional(transactionManager = "transactionManager")
public class LoginControllerTest {

    private static Logger logger = Logger.getLogger(LoginControllerTest.class);

    private MockMvc mockMvc;

    @Resource
    private LoginController loginController;

    @Before
    public void before() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: login(HttpServletRequest request)
     */
    @Test
    public void testLogin() throws Exception {
        try {

            JSONObject data = new JSONObject();
            data.put(REQUEST_USERNAME_JSON, "windawings");
            data.put(REQUEST_PASSWORD_JSON, "123");

            ResultActions resultActions =
              this.mockMvc.perform(MockMvcRequestBuilders
                                     .post("/api/login/", REQUEST_TYPE_JSON)
                                     .characterEncoding(HTTP_UTF8)
                                     .contentType(APPLICATION_JSON_UTF8)
                                     .content(data.toJSONString())
                                     .accept(APPLICATION_JSON_UTF8));
            MvcResult mvcResult = resultActions.andExpect(status().isOk())
                                               .andDo(print())
                                               .andReturn();

            JSONObject response = (JSONObject) JSON.parse(mvcResult.getResponse().getContentAsString());

            JSONObject output = new JSONObject();
            output.put(RESPONSE_STATUS, response.get(RESPONSE_STATUS));
            output.put(SESSION_USER, response.get(SESSION_USER));

            logger.info(output.toJSONString());

      /*logger.info(
        "\"status\":"
        + JSON.toJSONString(mvcResult.getModelAndView().getModel().get(RESPONSE_STATUS))
        + ", "
        + "\"userinfo\":"
        + JSON.toJSONString(mvcResult.getModelAndView().getModel().get(SESSION_USER)));*/
        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }

    }
}
