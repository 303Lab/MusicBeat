package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SingerAlbum implements Serializable {

    private static final long serialVersionUID = 7031856981307468540L;

    private Singer singer;

    private Album album;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(singer.toString());
        list.add(album.toString());

        return list.toString();
    }

    public SingerAlbum() {}

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}