package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
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
        list.add(album.toString());
        for (Label label : labels) {
            list.add(label.toString());
        }

        return list.toString();
    }

    private Integer id;

    private String name;

    private String lyrics;

    private String link;

    private Album album;

    private List<Label> labels;

    public Music(Integer id, String name, String lyrics, String link) {
        this.id = id;
        this.name = name == null ? null : name.trim();
        this.lyrics = lyrics == null ? null : lyrics.trim();
        this.link = link == null ? null : link.trim();
    }

    public Music() {}

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

    public Album getAlbum() {
        return album;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
}