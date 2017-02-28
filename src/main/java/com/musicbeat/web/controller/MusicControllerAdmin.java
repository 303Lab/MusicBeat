package com.musicbeat.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.musicbeat.web.model.Music;
import com.musicbeat.web.service.MusicServiceAdmin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import static com.musicbeat.web.model.constant.Constants.HTTP_UTF8;
import static com.musicbeat.web.model.constant.Constants.REQUEST_ALBUMID_JSON;
import static com.musicbeat.web.model.constant.Constants.REQUEST_MUSICID_JSON;
import static com.musicbeat.web.model.constant.Constants.REQUEST_MUSICLINK_JSON;
import static com.musicbeat.web.model.constant.Constants.REQUEST_MUSICLYRICS_JSON;
import static com.musicbeat.web.model.constant.Constants.REQUEST_MUSICNAME_JSON;
import static com.musicbeat.web.model.constant.Constants.REQUEST_SINGERID_JSON;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_STATUS;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_SUCCESS;
import static com.musicbeat.web.model.constant.Constants.SESSION_MUSIC;
import static com.musicbeat.web.utils.ModelConvertUtil.convert2ViewModelIgnoreNull;

//import static com.musicbeat.web.model.constant.Constants.ACCESS_TOKEN;

/**
 * Created by gyz on 2017/2/25.
 */
@Controller("MusicControllerAdmin")
public class MusicControllerAdmin extends BaseController{

    @Resource
    private MusicServiceAdmin musicService;

    @RequestMapping(value = "/findAllMusics", method = RequestMethod.POST)
    public @ResponseBody ModelMap findAllMusics(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {
        ModelMap model = new ModelMap();
        //String singername = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERNAME_JSON), HTTP_UTF8);
        List<Music> musics = musicService.findMusicAll();
        model.put(SESSION_MUSIC, musics);
        model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
        //model.put(ACCESS_TOKEN, "bear test string from ModelAndView");
        // model.put(RESPONSE_MESSAGE, RESPONSE_MESSAGE_SUCCESS);
        // 存入Session
        session.setAttribute(SESSION_MUSIC, musics);
        //session.setAttribute(ACCESS_TOKEN, "bear test string from SessionCache");

        return model;

    }

    @RequestMapping(value = "/findMusics", method = RequestMethod.POST)
    public @ResponseBody
    ModelMap findMusics(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {
        ModelMap model = new ModelMap();
        String musicname = URLDecoder.decode(jsonObject.getString(REQUEST_MUSICNAME_JSON), HTTP_UTF8);

        List<Music> musics =  musicService.findMusicByName(musicname,false);


            model.put(SESSION_MUSIC, musics);
            model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
           // model.put(ACCESS_TOKEN, "bear test string from ModelAndView");
           // model.put(RESPONSE_MESSAGE, RESPONSE_MESSAGE_SUCCESS);
            // 存入Session
            session.setAttribute(SESSION_MUSIC, musics);
            //session.setAttribute(ACCESS_TOKEN, "bear test string from SessionCache");
        return model;

    }

    @RequestMapping(value = "/addMusic", method = RequestMethod.POST)
    public @ResponseBody ModelMap addMusic(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {

        ModelMap model = new ModelMap();

        String[] checkbox = request.getParameterValues("checkbox");
        // 解析Json对象
        String musicname = URLDecoder.decode(jsonObject.getString(REQUEST_MUSICNAME_JSON), HTTP_UTF8);
        String musiclrc = URLDecoder.decode(jsonObject.getString(REQUEST_MUSICLYRICS_JSON), HTTP_UTF8);
        String musiclink = URLDecoder.decode(jsonObject.getString(REQUEST_MUSICLINK_JSON), HTTP_UTF8);
        String singerid = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERID_JSON), HTTP_UTF8);
        String albumid = URLDecoder.decode(jsonObject.getString(REQUEST_ALBUMID_JSON), HTTP_UTF8);
        Integer sid = Integer.valueOf(singerid);
        Integer aid = Integer.valueOf(albumid);
        Music music =new Music();
        music.setLyrics(musiclrc);
        music.setName(musicname);
        music.setLink(musiclink);


        musicService.add(request, music, sid, aid);

        musicService.editLabel(checkbox,music.getId());

        Music  viewmusic = musicService.findByMusicId(music.getId());


        JSONObject musicViewModel = convert2ViewModelIgnoreNull(viewmusic);
        model.put(SESSION_MUSIC, musicViewModel);
        model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
        //model.put(ACCESS_TOKEN, "bear test string from ModelAndView");
       // model.put(RESPONSE_MESSAGE, RESPONSE_MESSAGE_SUCCESS);
        // 存入Session
        session.setAttribute(SESSION_MUSIC, musicViewModel);
        //session.setAttribute(ACCESS_TOKEN, "bear test string from SessionCache");

        return model;
    }

    @RequestMapping(value = "/updateMusic", method = RequestMethod.POST)
    public @ResponseBody ModelMap updateMusic(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {
        ModelMap model = new ModelMap();
        String[] checkbox = request.getParameterValues("checkbox");
        // 解析Json对象
        String musicid = URLDecoder.decode(jsonObject.getString(REQUEST_MUSICID_JSON), HTTP_UTF8);
        Integer id = Integer.valueOf(musicid).intValue();
        String musicname = URLDecoder.decode(jsonObject.getString(REQUEST_MUSICNAME_JSON), HTTP_UTF8);
        String musiclrc = URLDecoder.decode(jsonObject.getString(REQUEST_MUSICLYRICS_JSON), HTTP_UTF8);
        String musiclink = URLDecoder.decode(jsonObject.getString(REQUEST_MUSICLINK_JSON), HTTP_UTF8);

        Music music =new Music();
        music.setId(id);
        music.setLyrics(musiclrc);
        music.setName(musicname);
        music.setLink(musiclink);
        musicService.update(request,music);

        musicService.updateLabel(checkbox,id);


        Music  viewmusic = musicService.findByMusicId(music.getId());


        JSONObject musicViewModel = convert2ViewModelIgnoreNull(viewmusic);
        model.put(SESSION_MUSIC, musicViewModel);
        model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
        //model.put(ACCESS_TOKEN, "bear test string from ModelAndView");
        //model.put(RESPONSE_MESSAGE, RESPONSE_MESSAGE_SUCCESS);
        // 存入Session
        session.setAttribute(SESSION_MUSIC, musicViewModel);
       // session.setAttribute(ACCESS_TOKEN, "bear test string from SessionCache");


        return model;



    }

    @RequestMapping(value = "/deleteMusic", method = RequestMethod.POST)
    public @ResponseBody boolean deleteMusic(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {
        String musicid = URLDecoder.decode(jsonObject.getString(REQUEST_MUSICID_JSON), HTTP_UTF8);
        Integer id = Integer.valueOf(musicid).intValue();
        Music album = musicService.findByMusicId(id);
        musicService.delete(request,album);
        return true;
    }
}
