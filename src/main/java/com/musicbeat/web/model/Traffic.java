package com.musicbeat.web.model;

import java.util.Date;

public class Traffic {
    private String id;

    private String url;

    private String seed;

    private Integer step;

    private Date time;

    public Traffic(String id, String url, String seed, Integer step, Date time) {
        this.id = id;
        this.url = url;
        this.seed = seed;
        this.step = step;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getSeed() {
        return seed;
    }

    public Integer getStep() {
        return step;
    }

    public Date getTime() {
        return time;
    }
}