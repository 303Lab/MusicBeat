package com.musicbeat.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.musicbeat.web.utils.JUnit4ClassRunner;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
import static com.musicbeat.web.model.constant.Constants.REQUEST_TYPE_JSON;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_STATUS;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * CategoryController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>2 21, 2017</pre>
 */

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"})
@Rollback(true)
@Transactional(transactionManager = "transactionManager")
public class CategoryControllerTest {
    private static Logger logger = Logger.getLogger(AuthControllerTest.class);
    private MockMvc mockMvc;

    @Resource
    private CategoryController categoryController;

    @Before
    public void before() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: latest_music_list()
     */
    @Test
    public void testLatest_music_list() throws Exception {
        try {
            ResultActions resultActions =
              this.mockMvc.perform(MockMvcRequestBuilders
                                     .get("/api/latest_music_list/", REQUEST_TYPE_JSON)
                                     .characterEncoding(HTTP_UTF8)
                                     .contentType(APPLICATION_JSON_UTF8)
                                     .accept(APPLICATION_JSON_UTF8));

            MvcResult mvcResult = resultActions.andExpect(status().isOk())
                                               .andDo(print())
                                               .andReturn();

            JSONObject response = (JSONObject) JSON.parse(mvcResult.getResponse().getContentAsString());

            JSONObject output = new JSONObject();
            output.put(RESPONSE_STATUS, response.get(RESPONSE_STATUS));

            logger.info(output.toJSONString());
        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }
//TODO: Test goes here... 
    }

    /**
     * Method: pAmount_music_list()
     */
    @Test
    public void testPAmount_music_list() throws Exception {
        try {
            ResultActions resultActions =
              this.mockMvc.perform(MockMvcRequestBuilders
                                     .get("/api/pAmount_music_list/", REQUEST_TYPE_JSON)
                                     .characterEncoding(HTTP_UTF8)
                                     .contentType(APPLICATION_JSON_UTF8)
                                     .accept(APPLICATION_JSON_UTF8));

            MvcResult mvcResult = resultActions.andExpect(status().isOk())
                                               .andDo(print())
                                               .andReturn();

            JSONObject response = (JSONObject) JSON.parse(mvcResult.getResponse().getContentAsString());

            JSONObject output = new JSONObject();
            output.put(RESPONSE_STATUS, response.get(RESPONSE_STATUS));

            logger.info(output.toJSONString());
        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }
//TODO: Test goes here... 
    }

    /**
     * Method: dAmount_music_list()
     */
    @Test
    public void testDAmount_music_list() throws Exception {
        try {
            ResultActions resultActions =
              this.mockMvc.perform(MockMvcRequestBuilders
                                     .get("/api/dAmount_music_list/", REQUEST_TYPE_JSON)
                                     .characterEncoding(HTTP_UTF8)
                                     .contentType(APPLICATION_JSON_UTF8)
                                     .accept(APPLICATION_JSON_UTF8));

            MvcResult mvcResult = resultActions.andExpect(status().isOk())
                                               .andDo(print())
                                               .andReturn();

            JSONObject response = (JSONObject) JSON.parse(mvcResult.getResponse().getContentAsString());

            JSONObject output = new JSONObject();
            output.put(RESPONSE_STATUS, response.get(RESPONSE_STATUS));

            logger.info(output.toJSONString());
        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }
//TODO: Test goes here... 
    }

    /**
     * Method: laber_music_list(@RequestBody JSONObject jsonObject)
     */
    @Test
    public void testLaber_music_list() throws Exception {
        try {
            ResultActions resultActions =
              this.mockMvc.perform(MockMvcRequestBuilders
                                     .get("/api/label_music_list/", REQUEST_TYPE_JSON)
                                     .characterEncoding(HTTP_UTF8)
                                     .contentType(APPLICATION_JSON_UTF8)
                                     .accept(APPLICATION_JSON_UTF8));

            MvcResult mvcResult = resultActions.andExpect(status().isOk())
                                               .andDo(print())
                                               .andReturn();

            JSONObject response = (JSONObject) JSON.parse(mvcResult.getResponse().getContentAsString());

            JSONObject output = new JSONObject();
            output.put(RESPONSE_STATUS, response.get(RESPONSE_STATUS));

            logger.info(output.toJSONString());
        } catch (Exception e) {
            logger.error(e, e.fillInStackTrace());
        }
//TODO: Test goes here... 
    }

} 
