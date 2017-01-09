package com.musicbeat.web.model;

public class Label {
    private Integer id;

    private Integer lid;

    private Integer mid;

    private String name;

    public Label(Integer id, Integer lid, Integer mid, String name) {
        this.id = id;
        this.lid = lid;
        this.mid = mid;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getLid() {
        return lid;
    }

    public Integer getMid() {
        return mid;
    }

    public String getName() {
        return name;
    }
}