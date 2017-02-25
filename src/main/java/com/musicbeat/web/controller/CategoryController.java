package com.musicbeat.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.musicbeat.web.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_EXCEPTION;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_FAIL;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_MESSAGE;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_STATUS;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_SUCCESS;
import static com.musicbeat.web.model.constant.Constants.SEARCH_ERROR;
import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;

;

/**
 * Created by Administrator on 2017/2/21.
 */
@Controller("CategoryController")
public class CategoryController extends BaseController {
    @Resource
    private CategoryService categoryService;

    /**
     * 新歌潮流榜 榜单歌曲只能看 加到播放列表才能放？
     */
    @RequestMapping(value = "/latest_music_list", method = RequestMethod.GET)
    public
    @ResponseBody
    ModelMap latest_music_list(
      @RequestParam(required = true, defaultValue = "1", name = "pageNum") Integer pageNum,
      @RequestParam(required = false, defaultValue = "10", name = "pageSize") Integer pageSize
    ) {
        ModelMap model = new ModelMap();
        try {
            PageHelper.startPage(pageNum, pageSize);
            JSONArray mvs = categoryService.findByReleaseTime();

            if (mvs != null) {
                model.put("新歌潮流榜", mvs);
                Date date = new Date();
                model.put("上榜时间", date);
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

    /**
     * 经典热歌榜
     */
    @RequestMapping(value = "/pAmount_music_list", method = RequestMethod.GET)
    public
    @ResponseBody
    ModelMap pAmount_music_list(
      @RequestParam(required = true, defaultValue = "1", name = "pageNum") Integer pageNum,
      @RequestParam(required = false, defaultValue = "10", name = "pageSize") Integer pageSize
    ) {
        ModelMap model = new ModelMap();
        try {
            PageHelper.startPage(pageNum, pageSize);
            JSONArray mvs = categoryService.findByPlayAmount();

            if (mvs != null) {
                model.put("播放次数最多的音乐", mvs);
                Date date = new Date();
                model.put("上榜时间", date);
                model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
            }

        } catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return model;
    }

    /**
     * 心随乐动榜
     *
     * @return
     */
    @RequestMapping(value = "/dAmount_music_list", method = RequestMethod.GET)
    public
    @ResponseBody
    ModelMap dAmount_music_list(
      @RequestParam(required = true, defaultValue = "1", name = "pageNum") Integer pageNum,
      @RequestParam(required = false, defaultValue = "10", name = "pageSize") Integer pageSize
    ) {
        ModelMap model = new ModelMap();
        try {
            PageHelper.startPage(pageNum, pageSize);
            JSONArray mvs = categoryService.findByDownloadAmount();

            if (mvs != null) {
                model.put("经典热歌榜", mvs);
                Date date = new Date();
                model.put("上榜时间", date);
                model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
            }

        } catch (Exception e) {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_EXCEPTION);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);

            logger.error(e, e.fillInStackTrace());
        }
        return model;
    }

    /**
     * 类别搜歌
     * 按子标签搜歌
     *
     * @return
     */
    @RequestMapping(value = "/label_music_list", method = RequestMethod.GET)
    public
    @ResponseBody
    ModelMap label_music_list(
      @RequestParam("label_name") String name,
      @RequestParam(required = true, defaultValue = "1", name = "pageNum") Integer pageNum,
      @RequestParam(required = false, defaultValue = "10", name = "pageSize") Integer pageSize
    ) {
        ModelMap model = new ModelMap();
        try {
            PageHelper.startPage(pageNum, pageSize);
            JSONArray mvs = categoryService.findByLabelName(name);

            if (mvs != null) {
                model.put("类别搜歌", mvs);
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
}
