package com.musicbeat.web.model;

public class Singer {
    private Integer id;

    private String name;

    private Boolean gender;

    private String lang;

    private String picture;

    private String introduction;

    private Boolean isBand;

    public Singer(Integer id, String name, Boolean gender, String lang, String picture, String introduction, Boolean isBand) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.lang = lang;
        this.picture = picture;
        this.introduction = introduction;
        this.isBand = isBand;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getGender() {
        return gender;
    }

    public String getLang() {
        return lang;
    }

    public String getPicture() {
        return picture;
    }

    public String getIntroduction() {
        return introduction;
    }

    public Boolean getIsBand() {
        return isBand;
    }
}