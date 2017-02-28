package com.musicbeat.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.musicbeat.web.service.MusicServiceAdmin;
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

import java.util.Date;

import static com.musicbeat.web.model.constant.Constants.*;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_STATUS;
import static com.musicbeat.web.model.constant.Constants.SESSION_SINGER;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/** 
* MusicControllerAdmin Tester. 
* 
* @author <Authors name> 
* @since <pre>2.25, 2017</pre>
* @version 1.0 
*/
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"})
@Rollback(true)
@Transactional(transactionManager = "transactionManager")
public class MusicControllerAdminTest {
    private static Logger logger = Logger.getLogger(MusicControllerAdminTest.class);
    private MockMvc mockMvc;
    @Resource
    private  MusicControllerAdmin musicControllerAdmin;
@Before
public void before() throws Exception {
    this.mockMvc = MockMvcBuilders.standaloneSetup(musicControllerAdmin).build();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findMusics(@RequestBody JSONObject jsonObject) 
* 
*/ 
@Test
public void testFindMusics() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addAlbum(@RequestBody JSONObject jsonObject, @RequestParam("imageInfo") MultipartFile image, @RequestParam("lrcInfo") MultipartFile lrc, @RequestParam("songInfo") MultipartFile song) 
* 
*/ 
@Test
public void testAddMusic() throws Exception {
//TODO: Test goes here...
    try {

        JSONObject data = new JSONObject();
        data.put(REQUEST_MUSICNAME_JSON, "宝哥");
        data.put(REQUEST_MUSICLINK_JSON, "C:\\Users\\gyz\\Desktop\\MusicBeat\\images\\Preparation.mp3");
        data.put(REQUEST_MUSICLYRICS_JSON,"C:\\Users\\gyz\\Desktop\\MusicBeat\\images\\回レ！雪月花.lrc");
        data.put(REQUEST_SINGERID_JSON,65);
        data.put(REQUEST_ALBUMID_JSON,74);

        ResultActions resultActions =
                this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/addMusic/", REQUEST_TYPE_JSON)
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
* Method: updateMusic(@RequestBody JSONObject jsonObject, @RequestParam("imageInfo") MultipartFile image, @RequestParam("lrcInfo") MultipartFile lrc, @RequestParam("songInfo") MultipartFile song) 
* 
*/ 
@Test
public void testUpdateMusic() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteMusic(@RequestBody JSONObject jsonObject) 
* 
*/ 
@Test
public void testDeleteMusic() throws Exception { 
//TODO: Test goes here... 
} 


} 
