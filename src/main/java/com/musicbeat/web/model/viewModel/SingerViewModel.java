package com.musicbeat.web.model.viewModel;

import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */
public class SingerViewModel {
    private Integer id;
    private String name;
    private String picture;
    private String introduction;

    private List<AlbumViewModel> musics;

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
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<AlbumViewModel> getMusics() {
        return musics;
    }

    public void setMusics(List<AlbumViewModel> musics) {
        this.musics = musics;
    }
}
