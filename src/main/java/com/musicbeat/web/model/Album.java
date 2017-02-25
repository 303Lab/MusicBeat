package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Album implements Serializable {

    private static final long serialVersionUID = 4893837664214562626L;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(id == null ? null : id.toString());
        list.add(name);
        list.add(releaseTime == null ? null : releaseTime.toString());
        list.add(picture);
        list.add(introduction);
        list.add(singer.toString());
        for (Music music : musics) {
            list.add(music.toString());
        }

        return list.toString();
    }

    private Integer id;

    private String name;

    private Date releaseTime;

    private String picture;

    private String introduction;

    private List<Music> musics;

    private Singer singer;

    public Album() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> music) {
        this.musics = music;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }
}