package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Singer implements Serializable {

    private static final long serialVersionUID = 8704081907096194569L;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(id == null ? null : id.toString());
        list.add(name);
        list.add(gender == null ? "嬲" : gender ? "男" : "女");
        list.add(lang);
        list.add(picture);
        list.add(isBand == null ? "个人" : isBand ? "组合" : "个人");
        list.add(introduction);

        return list.toString();
    }

    private Integer id;

    private String name;

    private Boolean gender;

    private String lang;

    private String picture;

    private Boolean isBand;

    private String introduction;

    private List<Album> albums;

    public Singer() {}

    public Singer(Integer id, String name, Boolean gender, String lang, String picture, Boolean isBand, String introduction, List<Album> albums) {
        this.id = id;
        this.name = name == null ? null : name.trim();
        this.gender = gender;
        this.lang = lang == null ? null : lang.trim();
        this.picture = picture == null ? null : picture.trim();
        this.isBand = isBand;
        this.introduction = introduction == null ? null : introduction.trim();
        this.albums = albums;
    }

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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Boolean getBand() {
        return isBand;
    }

    public void setBand(Boolean band) {
        isBand = band;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}