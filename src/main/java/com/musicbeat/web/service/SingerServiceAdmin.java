package com.musicbeat.web.service;

import com.musicbeat.web.model.Singer;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by gyz on 2017/2/25.
 */
public interface SingerServiceAdmin {
    Logger logger = Logger.getLogger(SingerServiceAdmin.class);

    List<Singer> findBySingerName(String name, Boolean like);

    Singer findBySingerId(Integer id);

    void add(HttpServletRequest request,Singer singer);

    void update(HttpServletRequest request,Singer singer);

    boolean delete(HttpServletRequest request,Singer singer);

    void addBand(Integer mid,Integer band);

    List<Singer> findSingerAll();
}
