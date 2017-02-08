package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Traffic implements Serializable {

    private static final long serialVersionUID = -4840773955407257972L;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(id);
        list.add(url);
        list.add(seed);
        list.add(step.toString());
        list.add(time.toString());

        return list.toString();
    }

    private String id;

    private String url;

    private String seed;

    private Integer step;

    private Date time;

    public Traffic(String id, String url, String seed, Integer step, Date time) {
        this.id = id == null ? null : id.trim();
        this.url = url == null ? null : url.trim();
        this.seed = seed == null ? null : seed.trim();
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