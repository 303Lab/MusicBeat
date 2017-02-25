package com.musicbeat.web.service;

import com.alibaba.fastjson.JSONArray;
import org.apache.log4j.Logger;

import java.text.ParseException;

/**
 * Created by Administrator on 2017/2/13.
 */
public interface CategoryService {
    Logger logger = Logger.getLogger(CategoryService.class);

    JSONArray findByReleaseTime() throws ParseException;

    JSONArray findByPlayAmount() throws ParseException;

    JSONArray findByDownloadAmount() throws ParseException;

    JSONArray findByLabelName(String labelName);
}
