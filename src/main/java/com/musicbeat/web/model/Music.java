package com.musicbeat.web.model;

import java.util.Date;

public class Music {
    private Integer id;

    private String name;

    private String lyrics;

    private String link;

    private Date duration;

    public Music(Integer id, String name, String lyrics, String link, Date duration) {
        this.id = id;
        this.name = name;
        this.lyrics = lyrics;
        this.link = link;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLyrics() {
        return lyrics;
    }

    public String getLink() {
        return link;
    }

    public Date getDuration() {
        return duration;
    }
}