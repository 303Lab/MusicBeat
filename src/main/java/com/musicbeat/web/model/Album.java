package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Album implements Serializable {

    private static final long serialVersionUID = 4893837664214562626L;

    private Integer id;

    private String name;

    private Date releaseTime;

    private String picture;

    private String introduction;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(id.toString());
        list.add(name);
        list.add(releaseTime.toString());
        list.add(picture);
        list.add(introduction);

        return list.toString();
    }

    public Album(Integer id, String name, Date releaseTime, String picture, String introduction) {
        this.id = id;
        this.name = name == null ? null : name.trim();
        this.releaseTime = releaseTime;
        this.picture = picture == null ? null : picture.trim();
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public String getPicture() {
        return picture;
    }

    public String getIntroduction() {
        return introduction;
    }
}