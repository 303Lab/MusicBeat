package com.musicbeat.web.service;

import com.musicbeat.web.model.Label;
import com.musicbeat.web.model.LabelGroup;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by gyz on 2017/2/27.
 */
public interface LabelServiceAdmin {
    Logger logger = Logger.getLogger(LabelServiceAdmin.class);

    List<LabelGroup> findLabelGroupByName(String name);

    LabelGroup findLabelGroupById(Integer gid);

    Label findLabelById(Integer lid);

    void addLabelGroup(LabelGroup labelGroup);

    boolean deleteLabelGroup(LabelGroup labelGroup);

    void addLabel(Label label,Integer labelGroupID);

    List<Label> findLabelAll();

    boolean deleteLabel(Label label);


}
