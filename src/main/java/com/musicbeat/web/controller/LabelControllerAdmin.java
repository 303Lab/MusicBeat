package com.musicbeat.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.musicbeat.web.model.Label;
import com.musicbeat.web.model.LabelGroup;
import com.musicbeat.web.service.LabelServiceAdmin;
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

import static com.musicbeat.web.model.constant.Constants.*;
import static com.musicbeat.web.model.constant.Constants.RESPONSE_SUCCESS;
import static com.musicbeat.web.model.constant.Constants.SESSION_SINGER;

/**
 * Created by gyz on 2017/2/27.
 */
@Controller("LabelControllerAdmin")
public class LabelControllerAdmin extends BaseController {

    @Resource
    private LabelServiceAdmin labelService;

    @RequestMapping(value = "/findLabelGroups", method = RequestMethod.POST)
    public
    @ResponseBody
    ModelMap findLabelGroups(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {
        ModelMap model = new ModelMap();
        String labelgroupname = URLDecoder.decode(jsonObject.getString(REQUEST_LABELGROUPNAME_JSON), HTTP_UTF8);
        List<LabelGroup> labelgroups = labelService.findLabelGroupByName(labelgroupname);
        model.put(SESSION_LABELGROUP, labelgroups);
        model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
        //model.put(ACCESS_TOKEN, "bear test string from ModelAndView");
        // model.put(RESPONSE_MESSAGE, RESPONSE_MESSAGE_SUCCESS);
        // 存入Session
        session.setAttribute(SESSION_LABELGROUP, labelgroups);
        //session.setAttribute(ACCESS_TOKEN, "bear test string from SessionCache");

        return model;
    }

    @RequestMapping(value = "/addLabelGroup", method = RequestMethod.POST)
    public
    @ResponseBody
    ModelMap addLabelGroup(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {

        ModelMap model = new ModelMap();
        // 解析Json对象
        String labelgroupname = URLDecoder.decode(jsonObject.getString(REQUEST_LABELGROUPNAME_JSON), HTTP_UTF8);
        LabelGroup labelGroup = new LabelGroup();
        labelGroup.setName(labelgroupname);
        labelService.addLabelGroup(labelGroup);

        LabelGroup newlabelgroup = labelService.findLabelGroupById(labelGroup.getId());
        model.put(SESSION_LABELGROUP, newlabelgroup);
        model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
        //model.put(ACCESS_TOKEN, "bear test string from ModelAndView");
        // model.put(RESPONSE_MESSAGE, RESPONSE_MESSAGE_SUCCESS);
        // 存入Session
        session.setAttribute(SESSION_LABELGROUP, newlabelgroup);
        //session.setAttribute(ACCESS_TOKEN, "bear test string from SessionCache");

        return model;
    }

    @RequestMapping(value = "/deleteLabelGroup", method = RequestMethod.POST)
    public
    @ResponseBody
    Boolean deleteLabelGroup(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {

        String labelgroupid = URLDecoder.decode(jsonObject.getString(REQUEST_LABELGROUPID_JSON), HTTP_UTF8);
        Integer gid = Integer.valueOf(labelgroupid).intValue();
       // String labelgroupname = URLDecoder.decode(jsonObject.getString(REQUEST_LABELGROUPNAME_JSON), HTTP_UTF8);
        LabelGroup labelGroup = labelService.findLabelGroupById(gid);
        labelService.deleteLabelGroup(labelGroup);
        return true;

    }


    @RequestMapping(value = "/findAllLabels", method = RequestMethod.POST)
    public
    @ResponseBody
    ModelMap findAllLabels(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {
        ModelMap model = new ModelMap();
        //String labelgroupname = URLDecoder.decode(jsonObject.getString(REQUEST_LABELGROUPNAME_JSON), HTTP_UTF8);
        List<Label> labels = labelService.findLabelAll();
        model.put(SESSION_LABEL, labels);
        model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
        //model.put(ACCESS_TOKEN, "bear test string from ModelAndView");
        // model.put(RESPONSE_MESSAGE, RESPONSE_MESSAGE_SUCCESS);
        // 存入Session
        session.setAttribute(SESSION_LABEL, labels);
        //session.setAttribute(ACCESS_TOKEN, "bear test string from SessionCache");

        return model;
    }



    @RequestMapping(value = "/addLabel", method = RequestMethod.POST)
    public
    @ResponseBody
    ModelMap addLabel(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {

        ModelMap model = new ModelMap();
        // 解析Json对象
        String labelgroupid = URLDecoder.decode(jsonObject.getString(REQUEST_LABELGROUPID_JSON), HTTP_UTF8);
        Integer gid = Integer.valueOf(labelgroupid).intValue();
        String labelname = URLDecoder.decode(jsonObject.getString(REQUEST_LABELNAME_JSON), HTTP_UTF8);
        Label label = new Label();
        label.setName(labelname);
        labelService.addLabel(label,gid);

        Label newlabel = labelService.findLabelById(label.getId());
        model.put(SESSION_LABEL, newlabel);
        model.put(RESPONSE_STATUS, RESPONSE_SUCCESS);
        //model.put(ACCESS_TOKEN, "bear test string from ModelAndView");
        // model.put(RESPONSE_MESSAGE, RESPONSE_MESSAGE_SUCCESS);
        // 存入Session
        session.setAttribute(SESSION_LABEL, newlabel);
        //session.setAttribute(ACCESS_TOKEN, "bear test string from SessionCache");

        return model;
    }

    @RequestMapping(value = "/deleteLabel", method = RequestMethod.POST)
    public
    @ResponseBody
    Boolean deleteLabel(@RequestBody JSONObject jsonObject) throws UnsupportedEncodingException {

        String labelid = URLDecoder.decode(jsonObject.getString(REQUEST_LABELID_JSON), HTTP_UTF8);
        Integer lid = Integer.valueOf(labelid).intValue();
        // String labelgroupname = URLDecoder.decode(jsonObject.getString(REQUEST_LABELGROUPNAME_JSON), HTTP_UTF8);
        Label label = labelService.findLabelById(lid);
        labelService.deleteLabel(label);
        return true;

    }

}


