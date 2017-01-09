package com.musicbeat.web.model;

public class SingerAlbum {
    private Integer sid;

    private Integer aid;

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