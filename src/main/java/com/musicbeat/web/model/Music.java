package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Music implements Serializable {

    private static final long serialVersionUID = 7711938471810119154L;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(id == null ? null : id.toString());
        list.add(name);
        list.add(lyrics);
        list.add(link);
        list.add(duration == null ? null : duration.toString());

        return list.toString();
    }

    private Integer id;

    private String name;

    private String lyrics;

    private String link;

    private Date duration;

    public Music(Integer id, String name, String lyrics, String link, Date duration) {
        this.id = id;
        this.name = name == null ? null : name.trim();
        this.lyrics = lyrics == null ? null : lyrics.trim();
        this.link = link == null ? null : link.trim();
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