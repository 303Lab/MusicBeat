package com.musicbeat.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.musicbeat.web.model.Singer;
import com.musicbeat.web.service.SingerServiceAdmin;
import com.musicbeat.web.utils.UploadFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import static com.musicbeat.web.model.constant.Constants.*;
import static com.musicbeat.web.utils.ModelConvertUtil.convert2ViewModelIgnoreNull;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

/**
 * Created by gyz on 2017/2/25.
 */
@Controller("SingerControllerAdmin")
public class SingerControllerAdmin extends BaseController{
    @Resource
    private SingerServiceAdmin singerService;

    @RequestMapping(value = "/findSingers", method = RequestMethod.POST)
    public @ResponseBody ModelMap findSingers(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {
        ModelMap model = new ModelMap();
        String singername = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERNAME_JSON), HTTP_UTF8);
        List<Singer> singers = singerService.findBySingerName(singername,false);
            model.put(SESSION_SINGER, singers);
            model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
            //model.put(ACCESS_TOKEN, "bear test string from ModelAndView");
           // model.put(RESPONSE_MESSAGE, RESPONSE_MESSAGE_SUCCESS);
            // 存入Session
            session.setAttribute(SESSION_SINGER, singers);
            //session.setAttribute(ACCESS_TOKEN, "bear test string from SessionCache");

        return model;

    }

    @RequestMapping(value = "/findAllSingers", method = RequestMethod.POST)
    public @ResponseBody ModelMap findAllSingers(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {
        ModelMap model = new ModelMap();
        //String singername = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERNAME_JSON), HTTP_UTF8);
        List<Singer> singers = singerService.findSingerAll();
        model.put(SESSION_SINGER, singers);
        model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
        //model.put(ACCESS_TOKEN, "bear test string from ModelAndView");
        // model.put(RESPONSE_MESSAGE, RESPONSE_MESSAGE_SUCCESS);
        // 存入Session
        session.setAttribute(SESSION_SINGER, singers);
        //session.setAttribute(ACCESS_TOKEN, "bear test string from SessionCache");

        return model;

    }


    @RequestMapping(value = "/addSinger", method = RequestMethod.POST)
    public @ResponseBody ModelMap addSinger(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {

        ModelMap model = new ModelMap();
        // 解析Json对象
        String singername = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERNAME_JSON), HTTP_UTF8);
        String singergender = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERGENDER_JSON), HTTP_UTF8);
        Integer sgint = Integer.valueOf(singergender);
        Boolean sg = UploadFile.IntertoBoolean(sgint);
        String singerlang = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERLANG_JSON), HTTP_UTF8);
        String singerpic = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERPIC_JSON), HTTP_UTF8);
        String singerisBand = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERISBAND_JSON), HTTP_UTF8);
        Integer sibint = Integer.valueOf(singerisBand);
        Boolean sib = UploadFile.IntertoBoolean(sibint);
        String singerinfo = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERINFO_JSON), HTTP_UTF8);


        Singer singer =new Singer();
        singer.setName(singername);
        singer.setGender(sg);
        singer.setIntroduction(singerinfo);
        singer.setBand(sib);
        singer.setLang(singerlang);
        singer.setPicture(singerpic);



        singerService.add(request,singer);

        Integer id = singer.getId();

       // singerService.addBand(id,sibint);



        Singer viewsinger = singerService.findBySingerId(id);
        if (viewsinger != null)
        {
            JSONObject singerViewModel = convert2ViewModelIgnoreNull(viewsinger);
            model.put(SESSION_SINGER, singerViewModel);
            model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
        }
        else {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_CREDENTIAL);
            response.setStatus(SC_UNAUTHORIZED);
        }
        return model;
    }

    @RequestMapping(value = "/updateSinger", method = RequestMethod.POST)
    public @ResponseBody ModelMap updateSinger(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {
        ModelMap model = new ModelMap();
        String singerid = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERID_JSON), HTTP_UTF8);
        Integer id = Integer.valueOf(singerid);
        String singername = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERNAME_JSON), HTTP_UTF8);
        String singergender = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERGENDER_JSON), HTTP_UTF8);
        Integer sgint = Integer.valueOf(singergender);
        Boolean sg = UploadFile.IntertoBoolean(sgint);
        String singerlang = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERLANG_JSON), HTTP_UTF8);
        String singerpic = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERPIC_JSON), HTTP_UTF8);
        String singerisBand = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERISBAND_JSON), HTTP_UTF8);
        Integer sibint = Integer.valueOf(singerisBand);
        Boolean sib = UploadFile.IntertoBoolean(sibint);
        String singerinfo = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERINFO_JSON), HTTP_UTF8);

        Singer singer =new Singer();
        singer.setId(id);
        singer.setName(singername);
        singer.setGender(sg);
        singer.setIntroduction(singerinfo);
        singer.setBand(sib);
        singer.setLang(singerlang);
        singer.setPicture(singerpic);
        singerService.update(request,singer);

        Singer newsinger = singerService.findBySingerId(id);

        model.put(SESSION_SINGER, newsinger);
        model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);


        return model;



    }

    @RequestMapping(value = "/deleteSinger", method = RequestMethod.POST)
    public @ResponseBody boolean deleteSinger(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {
        String singerid = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERID_JSON), HTTP_UTF8);
        Integer id = Integer.valueOf(singerid);
        Singer singer = singerService.findBySingerId(id);
        singerService.delete(request,singer);
        return true;
    }


}
