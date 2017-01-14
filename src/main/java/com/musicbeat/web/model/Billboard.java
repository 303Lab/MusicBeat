package com.musicbeat.web.model;

import java.util.Date;

public class Billboard {
    private Date time;

    private Integer mid;

    private Long downloadAmount;

    private Long playAmount;

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