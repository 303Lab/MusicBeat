package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SingerAlbum implements Serializable{

    private static final long serialVersionUID = 7031856981307468540L;

    private Integer sid;

    private Integer aid;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(sid.toString());
        list.add(aid.toString());

        return list.toString();
    }

    public SingerAlbum(Integer sid, Integer aid) {
        this.sid = sid;
        this.aid = aid;
    }

    public Integer getSid() {
        return sid;
    }

    public Integer getAid() {
        return aid;
    }
}