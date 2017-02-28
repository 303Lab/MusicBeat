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

import static com.musicbeat.web.model.constant.Constants.*;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_STATUS;
import static com.musicbeat.web.model.constant.Constants.SESSION_SINGER;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/** 
* SingerControllerAdmin Tester. 
* 
* @author <Authors name> 
* @since <pre>2.25, 2017</pre>
* @version 1.0 
*/
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"})
@Rollback(true)
@Transactional(transactionManager = "transactionManager")
public class SingerControllerAdminTest {
    private static Logger logger = Logger.getLogger(SingerControllerAdminTest.class);

    private MockMvc mockMvc;

    @Resource
    private SingerControllerAdmin singerController;
@Before
public void before() throws Exception {
    this.mockMvc = MockMvcBuilders.standaloneSetup(singerController).build();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findSingers(@RequestBody JSONObject jsonObject) 
* 
*/ 
@Test
public void testFindSingers() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addSinger(@RequestBody JSONObject jsonObject) 
* 
*/ 
@Test
public void testAddSinger() throws Exception { 
//TODO: Test goes here...
    try {

        JSONObject data = new JSONObject();
        data.put(REQUEST_SINGERNAME_JSON, "gyz");
        data.put(REQUEST_SINGERGENDER_JSON, "1");
        data.put(REQUEST_SINGERLANG_JSON, "中国");
        data.put(REQUEST_SINGERISBAND_JSON, "0");
        data.put(REQUEST_SINGERPIC_JSON,"C:\\Users\\gyz\\Desktop\\MusicBeat\\images\\7.jpg");
        data.put(REQUEST_SINGERINFO_JSON, "湖北荆门人");

        ResultActions resultActions =
                this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/addSinger/", REQUEST_TYPE_JSON)
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
        output.put(SESSION_SINGER, response.get(SESSION_SINGER));

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

/** 
* 
* Method: updateSinger(@RequestBody JSONObject jsonObject) 
* 
*/ 
@Test
public void testUpdateSinger() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteSinger(@RequestBody JSONObject jsonObject) 
* 
*/ 
@Test
public void testDeleteSinger() throws Exception { 
//TODO: Test goes here... 
} 


} 
