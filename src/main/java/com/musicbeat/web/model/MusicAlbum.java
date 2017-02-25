package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MusicAlbum implements Serializable {

    private static final long serialVersionUID = 2104567201514799362L;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(mid == null ? null : mid.toString());
        list.add(aid == null ? null : aid.toString());
        list.add(music.toString());
        list.add(album.toString());

        return list.toString();
    }

    private Integer mid;

    private Integer aid;

    private Music music;

    private Album album;

    public MusicAlbum() {}

    public MusicAlbum(Integer mid, Integer aid) {
        this.mid = mid;
        this.aid = aid;
    }

    public Integer getMid() {
        return mid;
    }

    public Integer getAid() {
        return aid;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}