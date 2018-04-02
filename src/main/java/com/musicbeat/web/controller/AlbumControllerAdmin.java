package com.musicbeat.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.musicbeat.web.model.Album;
import com.musicbeat.web.service.AlbumServiceAdmin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.musicbeat.web.model.constant.Constants.*;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_ERROR_CREDENTIAL;
import static com.musicbeat.web.utils.ModelConvertUtil.convert2ViewModelIgnoreNull;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

/**
 * Created by gyz on 2017/2/25.
 */
@Controller("AlbumControllerAdmin")
public class AlbumControllerAdmin extends BaseController {
    @Resource
    private AlbumServiceAdmin albumService;

    @RequestMapping(value = "/findAlbums", method = RequestMethod.POST)
    public @ResponseBody
    ModelMap findAlbums(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {
        ModelMap model = new ModelMap();
        String albumname = URLDecoder.decode(jsonObject.getString(REQUEST_ALBUMNAME_JSON), HTTP_UTF8);

        List<Album> albums = albumService.findAlbumByName(albumname, false);

        if (albums != null) {
            model.put(SESSION_ALBUM, albums);
            model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
            // model.put(ACCESS_TOKEN, "bear test string from ModelAndView");
            // model.put(RESPONSE_MESSAGE, RESPONSE_MESSAGE_SUCCESS);
            // 存入Session
            session.setAttribute(SESSION_ALBUM, albums);
            //session.setAttribute(ACCESS_TOKEN, "bear test string from SessionCache");
        } else {
            model.put(RESPONSE_STATUS, RESPONSE_FAIL);
            model.put(RESPONSE_MESSAGE, RESPONSE_ERROR_CREDENTIAL);
            response.setStatus(SC_UNAUTHORIZED);
        }
        return model;
    }

    @RequestMapping(value = "/findAllAlbums", method = RequestMethod.POST)
    public @ResponseBody
    ModelMap findAllAlbums(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {
        ModelMap model = new ModelMap();
        //String singername = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERNAME_JSON), HTTP_UTF8);
        List<Album> albums = albumService.findAlbumAll();
        model.put(SESSION_ALBUM, albums);
        model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
        //model.put(ACCESS_TOKEN, "bear test string from ModelAndView");
        // model.put(RESPONSE_MESSAGE, RESPONSE_MESSAGE_SUCCESS);
        // 存入Session
        session.setAttribute(SESSION_ALBUM, albums);
        //session.setAttribute(ACCESS_TOKEN, "bear test string from SessionCache");

        return model;

    }

    @RequestMapping(value = "/addAlbum", method = RequestMethod.POST)
    public @ResponseBody
    ModelMap addAlbum(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException, ParseException {

        ModelMap model = new ModelMap();
        // 解析Json对象
        String albumname = URLDecoder.decode(jsonObject.getString(REQUEST_ALBUMNAME_JSON), HTTP_UTF8);
        String albumreleaseTime = URLDecoder.decode(jsonObject.getString(REQUEST_ALBUMRELEASETIME_JSON), HTTP_UTF8);

        // SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
        // Date albumrt= formatter.parse(albumreleaseTime);
        //Date albumrt = new Date(albumreleaseTime);
        Date albumrt = java.sql.Date.valueOf(albumreleaseTime);
        String albumpic = URLDecoder.decode(jsonObject.getString(REQUEST_ALBUMPIC_JSON), HTTP_UTF8);
        String albuminfo = URLDecoder.decode(jsonObject.getString(REQUEST_ALBUMINFO_JSON), HTTP_UTF8);
        String singerid = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERID_JSON), HTTP_UTF8);
        Integer sid = Integer.valueOf(singerid).intValue();

        Album album = new Album();
        album.setName(albumname);
        album.setIntroduction(albuminfo);
        album.setPicture(albumpic);
        album.setReleaseTime(albumrt);

        albumService.add(request, album, sid);

        Album viewalbum = albumService.findByAlbumId(album.getId());

        JSONObject singerViewModel = convert2ViewModelIgnoreNull(viewalbum);
        model.put(SESSION_ALBUM, singerViewModel);
        model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
        // model.put(ACCESS_TOKEN, "bear test string from ModelAndView");
        // model.put(RESPONSE_MESSAGE, RESPONSE_MESSAGE_SUCCESS);
        // 存入Session
        session.setAttribute(SESSION_ALBUM, singerViewModel);
        //session.setAttribute(ACCESS_TOKEN, "bear test string from SessionCache");

        return model;
    }

    @RequestMapping(value = "/updateAlbum", method = RequestMethod.POST)
    public @ResponseBody
    ModelMap updateAlbum(@RequestBody JSONObject jsonObject, MultipartFile image)
      throws UnsupportedEncodingException, ParseException {
        ModelMap model = new ModelMap();
        String albumid = URLDecoder.decode(jsonObject.getString(REQUEST_ALBUMID_JSON), HTTP_UTF8);
        Integer id = Integer.valueOf(albumid).intValue();
        String albumname = URLDecoder.decode(jsonObject.getString(REQUEST_ALBUMNAME_JSON), HTTP_UTF8);
        String albumreleaseTime = URLDecoder.decode(jsonObject.getString(REQUEST_ALBUMRELEASETIME_JSON), HTTP_UTF8);
        // SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
        // Date albumrt= formatter.parse(albumreleaseTime);
        Date albumrt = java.sql.Date.valueOf(albumreleaseTime);
        String albumpic = URLDecoder.decode(jsonObject.getString(REQUEST_ALBUMPIC_JSON), HTTP_UTF8);
        String albuminfo = URLDecoder.decode(jsonObject.getString(REQUEST_ALBUMINFO_JSON), HTTP_UTF8);

        Album album = new Album();
        album.setId(id);
        album.setName(albumname);
        album.setIntroduction(albuminfo);
        album.setPicture(albumpic);
        album.setReleaseTime(albumrt);

        albumService.update(request, album);

        Album newalbum = albumService.findByAlbumId(id);

        model.put(SESSION_ALBUM, newalbum);
        model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
        //model.put(ACCESS_TOKEN, "bear test string from ModelAndView");
        //model.put(RESPONSE_MESSAGE, RESPONSE_MESSAGE_SUCCESS);
        // 存入Session
        session.setAttribute(SESSION_ALBUM, newalbum);
        //session.setAttribute(ACCESS_TOKEN, "bear test string from SessionCache");

        return model;

    }

    @RequestMapping(value = "/deleteAlbum", method = RequestMethod.POST)
    public @ResponseBody
    boolean deleteAlbum(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {
        String albumid = URLDecoder.decode(jsonObject.getString(REQUEST_ALBUMID_JSON), HTTP_UTF8);
        Integer id = Integer.valueOf(albumid).intValue();
        // String singername = URLDecoder.decode(jsonObject.getString(REQUEST_SINGERNAME_JSON), HTTP_UTF8);
        Album album = albumService.findByAlbumId(id);
        albumService.delete(request, album);
        return true;
    }
}
