package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Label implements Serializable {

    private static final long serialVersionUID = 1332081784469453338L;

    private Integer id;

    private Integer gid;

    private String name;

    private List<Music> musics;

    public Label() {}

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(id == null ? null : id.toString());
        list.add(gid == null ? null : gid.toString());
        list.add(name);
        for (Music music : musics) {
            list.add(music.toString());
        }

        return list.toString();
    }

    public Label(Integer id, Integer gid, String name) {
        this.id = id;
        this.gid = gid;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }
}