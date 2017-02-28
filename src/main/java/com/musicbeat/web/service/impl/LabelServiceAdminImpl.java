package com.musicbeat.web.service.impl;

import com.musicbeat.web.mapper.LabelGroupMapper;
import com.musicbeat.web.mapper.LabelMapper;
import com.musicbeat.web.mapper.MusicLabelMapper;
import com.musicbeat.web.model.Label;
import com.musicbeat.web.model.LabelGroup;
import com.musicbeat.web.service.LabelServiceAdmin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gyz on 2017/2/27.
 */
@Service
public class LabelServiceAdminImpl implements LabelServiceAdmin{

    @Resource
    private LabelGroupMapper labelGroupMapper;
    @Resource
    private LabelMapper labelMapper;
    @Resource
    private MusicLabelMapper musicLabelMapper;

    @Override
    public List<LabelGroup> findLabelGroupByName(String name)
    {
        return labelGroupMapper.selectLabelGroupByName(name,false);
    }

    @Override
    public LabelGroup findLabelGroupById(Integer gid)
    {
        return labelGroupMapper.selectByPrimaryKey(gid);
    }

    @Override
    public Label findLabelById(Integer lid)
    {
        return labelMapper.selectById(lid);
    }

    @Override
    public List<Label> findLabelAll()
    {
        return labelMapper.selectAll();
    }

    @Override
    public void addLabelGroup(LabelGroup labelGroup)
    {
        labelGroupMapper.insert(labelGroup);
    }

    @Override
    public boolean deleteLabelGroup(LabelGroup labelGroup)
    {

        List<Integer> labelIds = labelMapper.selectLabelIdByLabelGroupId(labelGroup.getId());
        if (labelIds.isEmpty()) {
            labelGroupMapper.deleteByPrimaryKey(labelGroup.getId());
            return true;
        }
        return false;
    }

    @Override
    public void addLabel(Label label, Integer labelGroupID)
    {
//        if (label.getId() == null) {
//            labelMapper.insert(null, labelGroupID, label.getName());
//        }
        //else
       // {
            labelMapper.insert(label.getId(), labelGroupID, label.getName());
        //}
    }

    @Override
    public boolean deleteLabel(Label label)
    {
        List<Integer> musicids = musicLabelMapper.selectMusicIdByLabelId(label.getId());
        if (!musicids.isEmpty())
        {
            for(int i=0;i<musicids.size();i++)
            {
                musicLabelMapper.deleteByPrimaryKey(musicids.get(i),label.getId());
            }

        }
        labelMapper.deleteByPrimaryKey(label.getId());
        return true;
    }
}
