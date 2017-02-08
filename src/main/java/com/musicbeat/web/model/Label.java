package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Label implements Serializable {

    private static final long serialVersionUID = -8149927506836925295L;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(id.toString());
        list.add(lid.toString());
        list.add(mid.toString());
        list.add(name);

        return list.toString();
    }

    private Integer id;

    private Integer lid;

    private Integer mid;

    private String name;

    public Label(Integer id, Integer lid, Integer mid, String name) {
        this.id = id;
        this.lid = lid;
        this.mid = mid;
        this.name = name == null ? null : name.trim();
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