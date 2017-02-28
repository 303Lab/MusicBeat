package com.musicbeat.web.service;

import com.musicbeat.web.model.Album;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by gyz on 2017/2/25.
 */
public interface AlbumServiceAdmin {
    Logger logger = Logger.getLogger(com.musicbeat.web.service.AlbumServiceAdmin.class);

    List<Album> findAlbumByName(String name, Boolean like);

    List<Album> findAlbumAll();

    Album findByAlbumId(Integer id);

    boolean add(HttpServletRequest request,Album album, Integer sid);

    boolean update(HttpServletRequest request,Album album);

    boolean delete(HttpServletRequest request,Album album);
}
