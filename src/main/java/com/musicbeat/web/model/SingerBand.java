package com.musicbeat.web.model;

public class SingerBand {
    private Integer sid;

    private Integer bid;

    public SingerBand(Integer sid, Integer bid) {
        this.sid = sid;
        this.bid = bid;
    }

    public Integer getSid() {
        return sid;
    }

    public Integer getBid() {
        return bid;
    }
}