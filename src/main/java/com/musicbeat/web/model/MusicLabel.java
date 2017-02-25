package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MusicLabel implements Serializable {

    private static final long serialVersionUID = -3013554632637956308L;

    private Integer mid;

    private Integer lid;

    private Music music;

    private Label label;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(mid == null ? null : mid.toString());
        list.add(lid == null ? null : lid.toString());
        list.add(music.toString());
        list.add(label.toString());
        return list.toString();
    }

    public MusicLabel(Integer mid, Integer lid) {
        this.mid = mid;
        this.lid = lid;
    }

    public Integer getMid() {
        return mid;
    }

    public Integer getLid() {
        return lid;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}