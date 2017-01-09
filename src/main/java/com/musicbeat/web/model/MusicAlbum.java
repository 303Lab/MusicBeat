package com.musicbeat.web.model;

public class MusicAlbum {
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