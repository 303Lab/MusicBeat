package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Billboard implements Serializable {

    private static final long serialVersionUID = 653848922839086989L;

    private Date time;

    private Integer mid;

    private Long downloadAmount;

    private Long playAmount;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(time.toString());
        list.add(mid.toString());
        list.add(downloadAmount.toString());
        list.add(playAmount.toString());

        return list.toString();
    }

    public Billboard(Date time, Integer mid, Long downloadAmount, Long playAmount) {
        this.time = time;
        this.mid = mid;
        this.downloadAmount = downloadAmount;
        this.playAmount = playAmount;
    }

    public Date getTime() {
        return time;
    }

    public Integer getMid() {
        return mid;
    }

    public Long getDownloadAmount() {
        return downloadAmount;
    }

    public Long getPlayAmount() {
        return playAmount;
    }
}