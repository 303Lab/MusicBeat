package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MusicAlbum implements Serializable{

    private static final long serialVersionUID = 2104567201514799362L;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(mid.toString());
        list.add(aid.toString());

        return list.toString();
    }

    private Integer mid;

    private Integer aid;

    public MusicAlbum(Integer mid, Integer aid) {
        this.mid = mid;
        this.aid = aid;
    }

    public Integer getMid() {
        return mid;
    }

    public Integer getAid() {
        return aid;
    }
}