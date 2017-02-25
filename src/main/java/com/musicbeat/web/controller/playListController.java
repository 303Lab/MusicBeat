package com.musicbeat.web.controller;

import com.musicbeat.web.model.Music;
import com.musicbeat.web.model.User;
import com.musicbeat.web.service.PlayListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_EXCEPTION;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_LOGOFF_USER_BLANK;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_FAIL;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_MESSAGE;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_STATUS;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_SUCCESS;
import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;

/**
 * Created by Administrator on 2017/2/21.
 */
@Controller("playListController")
public class playListController extends BaseController {

    @Resource
    private PlayListService playListService;

    /*添加音乐到列表*/
    @RequestMapping(value = "/AddMusicToList", method = RequestMethod.GET)
    public @ResponseBody ModelMap AddMusicToList(@RequestParam("music_id") Integer id, @RequestParam(required = true, defaultValue = "1", name = "pageNum") Integer pageNum, @RequestParam(required = false, defaultValue = "10", name = "pageSize") Integer pageSize) {

        ModelMap model = new ModelMap();

        try {
            User user = (User) session.getAttribute("SESSION_USER");
            if (user == null) {
                logger.info("用户未登录");
                model.put(RESPONSE_STATUS, RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_LOGOFF_USER_BLANK);
                response.setStatus(SC_NOT_FOUND);
                return null;
            }

            playListService.addMusicToList(id, user.getId());
            model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);

        } catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return model;
    }

    /*从列表中删除音乐*/
    @RequestMapping(value = "/DelMusicFromList", method = RequestMethod.GET)
    public @ResponseBody ModelMap DelMusicFromList(@RequestParam("music_id") Integer id, @RequestParam(required = true, defaultValue = "1", name = "pageNum") Integer pageNum, @RequestParam(required = false, defaultValue = "10", name = "pageSize") Integer pageSize) {
        ModelMap model = new ModelMap();

        try {
            User user = (User) session.getAttribute("SESSION_USER");
            if (user == null) {
                logger.info("用户未登录");
                model.put(RESPONSE_STATUS, RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_LOGOFF_USER_BLANK);
                response.setStatus(SC_NOT_FOUND);
                return null;
            }

            playListService.deleteMusicFromList(id, user.getId());
            model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);

        } catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return model;
    }

    /*getMusics 获得歌曲集 恢复到播放列表上*/
    @RequestMapping(value = "/GetMusicsFromList", method = RequestMethod.GET)
    public @ResponseBody ModelMap GetMusicsFromList(@RequestParam(required = true, defaultValue = "1", name = "pageNum") Integer pageNum, @RequestParam(required = false, defaultValue = "10", name = "pageSize") Integer pageSize) {

        ModelMap model = new ModelMap();

        try {
            User user = (User) session.getAttribute("SESSION_USER");
            if (user == null) {
                logger.info("用户未登录");
                model.put(RESPONSE_STATUS, RESPONSE_FAIL);
                model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_LOGOFF_USER_BLANK);
                response.setStatus(SC_NOT_FOUND);
                return null;
            }

            List<Music> musics = playListService.getByUser(user.getId());
            model.put("用户音乐", musics);
            model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);

        } catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return model;
    }

    /*downloadMusic 下载歌曲*/
}
