package com.musicbeat.web.model;

public class Singer {
    private Integer id;

    private String name;

    private Boolean gender;

    private String lang;

    private String picture;

    private Boolean isBand;

    private String introduction;

    public Singer(Integer id, String name, Boolean gender, String lang, String picture, Boolean isBand, String introduction) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.lang = lang;
        this.picture = picture;
        this.isBand = isBand;
        this.introduction = introduction;
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

    public Boolean getIsBand() {
        return isBand;
    }

    public String getIntroduction() {
        return introduction;
    }
}