package com.musicbeat.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.musicbeat.web.model.Label;
import com.musicbeat.web.model.Music;
import com.musicbeat.web.model.Singer;
import com.musicbeat.web.model.viewModel.MusicViewModel;
import com.musicbeat.web.service.MusicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.List;

import static com.musicbeat.web.model.constant.Constants.*;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_EXCEPTION;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_MESSAGE;
import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;

/**
 * Created by Administrator on 2017/2/21.
 */

@Controller("MusicController")
public class MusicController extends BaseController {
    @Resource
    private MusicService musicService;

    /*点击歌手显示歌曲*/
    @RequestMapping(value = "/Musics_of_Singer", method = RequestMethod.GET)
    public @ResponseBody ModelMap Musics_of_Singer(@RequestParam("singer_id") Integer id, @RequestParam(required = true,defaultValue = "1",name = "pageNum") Integer pageNum, @RequestParam(required = false,defaultValue = "10",name = "pageSize") Integer pageSize) {
        ModelMap model = new ModelMap();
        try {
            PageHelper.startPage(pageNum, pageSize);
            JSONArray mvs = musicService.selectBySingerId(id);

            if (mvs != null) {
                model.put("MusicsBySingerId",mvs);
                model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
            } else {
                model.put(RESPONSE_STATUS, RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, SEARCH_ERROR);
                response.setStatus(SC_NOT_FOUND);

                logger.error("NOT FOUND");
            }

        } catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return model;
    }

    /*点击歌曲 在播放器中进行播放*/
    @RequestMapping(value = "/Music_of_MusicId", method = RequestMethod.GET)
    public @ResponseBody ModelMap Music_of_MusicId(@RequestParam("music_id") Integer id, @RequestParam(required = true,defaultValue = "1",name = "pageNum") Integer pageNum, @RequestParam(required = false,defaultValue = "10",name = "pageSize") Integer pageSize) {
        ModelMap model = new ModelMap();
        try {
            PageHelper.startPage(pageNum, pageSize);
            MusicViewModel mv = musicService.getByMusicId(id);

            if (mv != null) {
                model.put("MusicByMusicId", mv);
                model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
            } else {
                model.put(RESPONSE_STATUS, RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, SEARCH_ERROR);
                response.setStatus(SC_NOT_FOUND);

                logger.error("NOT FOUND");
            }

        } catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return model;
    }

    /*显示所有歌曲 随机显示*/
    @RequestMapping(value = "/All_Musics", method = RequestMethod.GET)
    public @ResponseBody ModelMap All_Musics(@RequestParam(required = true,defaultValue = "1",name = "pageNum") Integer pageNum, @RequestParam(required = false,defaultValue = "10",name = "pageSize") Integer pageSize) {
        ModelMap model = new ModelMap();
        try {
            PageHelper.startPage(pageNum, pageSize);
            JSONArray musics = musicService.getAll();

            if (musics != null) {
                model.put("All_Musics", musics);
                model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
            } else {
                model.put(RESPONSE_STATUS, RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, SEARCH_ERROR);
                response.setStatus(SC_NOT_FOUND);

                logger.error("NOT FOUND");
            }

        } catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return model;
    }

    /*显示所有歌手 随机显示一些歌手*/
    @RequestMapping(value = "/All_Singers", method = RequestMethod.GET)
    public @ResponseBody ModelMap All_Singers(@RequestParam(required = true,defaultValue = "1",name = "pageNum") Integer pageNum, @RequestParam(required = false,defaultValue = "28",name = "pageSize") Integer pageSize) {
        ModelMap model = new ModelMap();
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Singer> singers = musicService.selectAll();

            if (singers != null) {
                model.put("All_Singer", singers);
                model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
            } else {
                model.put(RESPONSE_STATUS, RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, SEARCH_ERROR);
                response.setStatus(SC_NOT_FOUND);

                logger.error("NOT FOUND");
            }

        } catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return model;
    }

    /*根据歌曲名查询歌曲*/
    @RequestMapping(value = "/Musics_of_Mname", method = RequestMethod.GET)
    public @ResponseBody ModelMap Musics_of_Mname(@RequestParam("music_name") String name, @RequestParam(required = true,defaultValue = "1",name = "pageNum") Integer pageNum, @RequestParam(required = false,defaultValue = "10",name = "pageSize") Integer pageSize) {
        ModelMap model = new ModelMap();
        try{
            PageHelper.startPage(pageNum,pageSize);
            JSONArray musics = musicService.getByMusicName(name);

            if (musics != null) {
                model.put("MusicsByMusicName", musics);
                model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
            } else {
                model.put(RESPONSE_STATUS, RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, SEARCH_ERROR);
                response.setStatus(SC_NOT_FOUND);

                logger.error("NOT FOUND");
            }

        } catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return model;
    }

    /*歌手分类*/
    @RequestMapping(value = "/Kinds_of_Singers", method = RequestMethod.GET)
    public @ResponseBody ModelMap Kinds_of_Singers(@RequestParam("country") String lang, @RequestParam("sex") Boolean gender, @RequestParam("isBand") Boolean isBand, @RequestParam(required = true, defaultValue = "1", name = "pageNum") Integer pageNum, @RequestParam(required = false, defaultValue = "28", name = "pageSize") Integer pageSize
    ) {
        ModelMap model = new ModelMap();
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Singer> singers = musicService.selectByLangAndGenderAndBand(lang, gender, isBand);

            if (singers != null) {
                model.put("KindsOfSingers", singers);
                model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
            } else {
                model.put(RESPONSE_STATUS, RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, SEARCH_ERROR);
                response.setStatus(SC_NOT_FOUND);

                logger.error("NOT FOUND");
            }

        } catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return model;
    }

    /*显示所有标签 随机显示一些标签*/
    @RequestMapping(value = "/All_Labels", method = RequestMethod.GET)
    public @ResponseBody ModelMap All_Labels(@RequestParam(required = true,defaultValue = "1",name = "pageNum") Integer pageNum, @RequestParam(required = false,defaultValue = "10",name = "pageSize") Integer pageSize) {
        ModelMap model = new ModelMap();
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Label> labels = musicService.selectAllLabers();

            if (labels != null) {
                model.put("All_Labels", labels);
                model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
            } else {
                model.put(RESPONSE_STATUS, RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, SEARCH_ERROR);
                response.setStatus(SC_NOT_FOUND);

                logger.error("NOT FOUND");
            }

        } catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return model;
    }

    /*根据歌手名查询歌手*/
    @RequestMapping(value = "/Singers_of_Sname", method = RequestMethod.GET)
    public @ResponseBody ModelMap Singers_of_Sname(@RequestParam("singer_name") String name, @RequestParam(required = true,defaultValue = "1",name = "pageNum") Integer pageNum, @RequestParam(required = false,defaultValue = "28",name = "pageSize") Integer pageSize) {
        ModelMap model = new ModelMap();
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Singer> singers = musicService.selectSingerBySname(name);

            if (singers != null) {
                model.put("SingersBySingerName",singers);
                model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
            } else {
                model.put(RESPONSE_STATUS, RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, SEARCH_ERROR);
                response.setStatus(SC_NOT_FOUND);

                logger.error("NOT FOUND");
            }

        }catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return model;
    }
}
