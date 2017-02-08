package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Singer implements Serializable{

    private static final long serialVersionUID = 8704081907096194569L;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(id.toString());
        list.add(name);
        list.add(gender == null ? "嬲" : gender ? "男" : "女");
        list.add(lang);
        list.add(picture);
        list.add(isBand ? "组合" : "个人");
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

    public Singer(Integer id, String name, Boolean gender, String lang, String picture, Boolean isBand, String introduction) {
        this.id = id;
        this.name = name == null ? null : name.trim();
        this.gender = gender;
        this.lang = lang == null ? null : lang.trim();
        this.picture = picture == null ? null : picture.trim();
        this.isBand = isBand;
        this.introduction = introduction == null ? null : introduction.trim();
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