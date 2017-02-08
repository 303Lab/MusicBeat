package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayList implements Serializable {

    private static final long serialVersionUID = -8227293891664035215L;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(mid.toString());
        list.add(uid.toString());

        return list.toString();
    }

    private Integer mid;

    private Integer uid;

    public PlayList(Integer mid, Integer uid) {
        this.mid = mid;
        this.uid = uid;
    }

    public Integer getMid() {
        return mid;
    }

    public Integer getUid() {
        return uid;
    }
}