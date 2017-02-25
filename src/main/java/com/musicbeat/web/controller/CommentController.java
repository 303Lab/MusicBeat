package com.musicbeat.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.musicbeat.web.mapper.UserMapper;
import com.musicbeat.web.model.MusicComment;
import com.musicbeat.web.model.User;
import com.musicbeat.web.service.CommentService;
import com.musicbeat.web.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.net.URLDecoder;

import static com.musicbeat.web.model.constant.Constants.HTTP_UTF8;
import static com.musicbeat.web.model.constant.Constants.REQUEST_COMMENT_JSON;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_EXCEPTION;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_FAIL;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_MESSAGE;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_STATUS;
import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

/**
 * Created by Administrator on 2017/2/21.
 */
@Controller("CommentController")
public class CommentController extends BaseController {
    @Resource
    private CommentService commentService;

    /**
     * 歌曲评论
     */
    @RequestMapping(value = "/comment_Music", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
//id从url中获取
    public @ResponseBody ModelMap pAmount_music_list(@RequestParam("m_id") Integer mid, @RequestBody JSONObject jsonObject) {

        ModelMap model = new ModelMap();
        JSONObject logObj = new JSONObject();

        try {
            User user = (User) session.getAttribute("SESSION_USER");
            if (user != null) {
                Integer uid = user.getId();
                String comment = URLDecoder.decode(jsonObject.getString(REQUEST_COMMENT_JSON), HTTP_UTF8);
                MusicComment musicComment = new MusicComment(null, uid, mid, comment);
                commentService.addCommentMusic(musicComment); //换成布尔类型
            } else {
                //调用登录
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
