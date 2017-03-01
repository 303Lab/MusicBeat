package com.musicbeat.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.musicbeat.web.model.User;
import com.musicbeat.web.service.PlayListService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.net.URLDecoder;
import java.util.List;
import java.util.concurrent.Callable;

import static com.musicbeat.web.model.constant.Constants.*;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_EXCEPTION;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_MESSAGE;
import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

/**
 * Created by Administrator on 2017/2/21.
 */
@Controller("playListController")
public class PlayListController extends BaseController {

    @Resource
    private PlayListService playListService;

    /*添加音乐到列表*/
    @RequestMapping(value = "/AddMusicToList", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Callable<ModelMap> AddMusicToList(@RequestBody JSONObject jsonObject) {
        ModelMap model = new ModelMap();

        try{
            User user = (User)session.getAttribute("SESSION_USER");
            if(user == null) {
                logger.info("用户未登录");
                model.put(RESPONSE_STATUS,RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_LOGOFF_USER_BLANK);
            }

            String plstr = URLDecoder.decode(jsonObject.getString(REQUEST_MUSICIDSLIST_JSON), HTTP_UTF8);
            JSONArray json = JSONArray.parseArray(plstr);
            List<Integer> musicIds = JSONArray.toJavaObject(json,List.class);

            session.setAttribute(SESSION_MUSICIDS,musicIds);

            model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);

        }catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return () -> model;
    }

    /*从列表中删除音乐*/
    @RequestMapping(value = "/DelMusicFromList", method = RequestMethod.POST)
    public @ResponseBody Callable<ModelMap> DelMusicFromList(@RequestParam("music_id") Integer id) {
        ModelMap model = new ModelMap();

        try{
            User user = (User)session.getAttribute("SESSION_USER");
            if(user == null) {
                logger.info("用户未登录");
                model.put(RESPONSE_STATUS,RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_LOGOFF_USER_BLANK);
            }

            List<Integer> musicList = (List<Integer>) session.getAttribute(SESSION_MUSICIDS);
            if(!(musicList.isEmpty())) {
                session.removeAttribute(SESSION_MUSICIDS);
                if(musicList.contains(id)) {
                    musicList.remove(id);
                }else {
                    logger.info(id +" isn't existed");
                    return null;
                }
            }
            session.setAttribute(SESSION_MUSICIDS,musicList);

            model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);

        }catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return () -> model;
    }

    /*从列表中清空音乐*/
    @RequestMapping(value = "/DelAllMusicFromList", method = RequestMethod.POST)
    public @ResponseBody Callable<ModelMap> DelAllMusicFromList() {
        ModelMap model = new ModelMap();

        try{
            User user = (User)session.getAttribute("SESSION_USER");
            if(user == null) {
                logger.info("用户未登录");
                model.put(RESPONSE_STATUS,RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_LOGOFF_USER_BLANK);
            }

            session.removeAttribute(SESSION_MUSICIDS);

            model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);

        }catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return () -> model;
    }

    /*getMusics 获得歌曲集 恢复到播放列表上*/
    @RequestMapping(value = "/GetMusicsFromList", method = RequestMethod.GET)
    public @ResponseBody Callable<ModelMap> GetMusicsFromList() {
        ModelMap model = new ModelMap();

        try{
            User user = (User)session.getAttribute("SESSION_USER");
            if(user == null) {
                logger.info("用户未登录");
                model.put(RESPONSE_STATUS,RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_LOGOFF_USER_BLANK);
            }

            JSONArray musics =  playListService.getByUser(user.getId());
            model.put("用户音乐",musics);
            model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);

        }catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return () -> model;
    }

    /*downloadMusic 下载歌曲*/
    @RequestMapping(value = "/DownloadMusicToUlist", method = RequestMethod.GET)
    public @ResponseBody Callable<ModelMap> DownloadMusicToUlist(@RequestParam("music_id") Integer id) {
        ModelMap model = new ModelMap();

        try{
            User user = (User)session.getAttribute("SESSION_USER");
            if(user == null) {
                logger.info("用户未登录");
                model.put(RESPONSE_STATUS,RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_LOGOFF_USER_BLANK);
            }

            String url =  playListService.downloadMusic(id);
            model.put("用户音乐",url);
            model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);

        }catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return () -> model;
    }

}
