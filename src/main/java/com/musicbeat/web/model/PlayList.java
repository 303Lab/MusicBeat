package com.musicbeat.web.model;

public class PlayList {
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