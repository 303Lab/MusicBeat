package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LabelGroup implements Serializable {

    private static final long serialVersionUID = 8453631193675517103L;

    private Integer id;

    private String name;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(id == null ? null : id.toString());
        list.add(name);

        return list.toString();
    }

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