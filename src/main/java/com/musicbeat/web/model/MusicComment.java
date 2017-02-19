package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MusicComment implements Serializable {

    private static final long serialVersionUID = -4175926311225998081L;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(id == null ? null : id.toString());
        list.add(uid == null ? null : uid.toString());
        list.add(mid == null ? null : mid.toString());
        list.add(comment);

        return list.toString();
    }

    private Integer id;

    private Integer uid;

    private Integer mid;

    private String comment;

    public MusicComment(Integer id, Integer uid, Integer mid, String comment) {
        this.id = id;
        this.uid = uid;
        this.mid = mid;
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getId() {
        return id;
    }

    public Integer getUid() {
        return uid;
    }

    public Integer getMid() {
        return mid;
    }

    public String getComment() {
        return comment;
    }
}