package com.musicbeat.web.model;

public class LabelGroup {
    private Integer id;

    private String name;

    public LabelGroup(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}