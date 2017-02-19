package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SingerBand implements Serializable {

    private static final long serialVersionUID = 7534334405315639006L;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(sid == null ? null : sid.toString());
        list.add(bid == null ? null : bid.toString());

        return list.toString();
    }

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