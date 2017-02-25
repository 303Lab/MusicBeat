package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayList implements Serializable {

    private static final long serialVersionUID = -8227293891664035215L;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();
        list.add(uid == null ? null : uid.toString());
        for (Music music : musics) {
            list.add(music.toString());
        }
        return list.toString();
    }

    private Integer uid;

    private List<Music> musics;

    public PlayList() {}

    public PlayList(Integer uid) {
        this.uid = uid;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }

    public Integer getUid() {
        return uid;
    }
}