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
import java.text.DateFormat;
import java.util.Date;

import static com.musicbeat.web.model.constant.Constants.HTTP_UTF8;
import static com.musicbeat.web.model.constant.Constants.REQUEST_ALBUMINFO_JSON;
import static com.musicbeat.web.model.constant.Constants.REQUEST_ALBUMNAME_JSON;
import static com.musicbeat.web.model.constant.Constants.REQUEST_ALBUMPIC_JSON;
import static com.musicbeat.web.model.constant.Constants.REQUEST_ALBUMRELEASETIME_JSON;
import static com.musicbeat.web.model.constant.Constants.REQUEST_SINGERID_JSON;
import static com.musicbeat.web.model.constant.Constants.REQUEST_TYPE_JSON;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_STATUS;
import static com.musicbeat.web.model.constant.Constants.SESSION_SINGER;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * AlbumControllerAdmin Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>2.25, 2017</pre>
 */
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"})
@Rollback(true)
@Transactional(transactionManager = "transactionManager")
public class AlbumControllerAdminTest {
    private static Logger logger = Logger.getLogger(AlbumControllerAdminTest.class);

    private MockMvc mockMvc;

    @Resource
    private AlbumControllerAdmin albumControllerAdmin;

    @Before
    public void before() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(albumControllerAdmin).build();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: findAlbums(@RequestBody JSONObject jsonObject)
     */
    @Test
    public void testFindAlbums() throws Exception {

    }

    /**
     * Method: addAlbum(@RequestBody JSONObject jsonObject)
     */
    @Test
    public void testAddAlbum() throws Exception {
        try {

            Date date = new Date();
            //DateFormat format = new SimpleDateFormat("yyyy-MM--dd");
            DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM);

            JSONObject data = new JSONObject();
            data.put(REQUEST_ALBUMNAME_JSON, "zq");
            data.put(REQUEST_ALBUMRELEASETIME_JSON, format.format(date));
            data.put(REQUEST_ALBUMPIC_JSON, "C:\\Users\\gyz\\Desktop\\MusicBeat\\images\\6.jpg");
            data.put(REQUEST_ALBUMINFO_JSON, "湖北荆门人");
            data.put(REQUEST_SINGERID_JSON, 65);

            ResultActions resultActions =
              this.mockMvc.perform(MockMvcRequestBuilders
                                     .post("/api/addAlbum/", REQUEST_TYPE_JSON)
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
     * Method: updateAlbum(@RequestBody JSONObject jsonObject, MultipartFile image)
     */
    @Test
    public void testUpdateAlbum() throws Exception {

    }

    /**
     * Method: deleteAlbum(@RequestBody JSONObject jsonObject)
     */
    @Test
    public void testDeleteAlbum() throws Exception {

    }

} 
