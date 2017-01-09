package com.musicbeat.web.model;

public class MusicComment {
    private Integer id;

    private Integer uid;

    private Integer mid;

    private String comment;

    public MusicComment(Integer id, Integer uid, Integer mid, String comment) {
        this.id = id;
        this.uid = uid;
        this.mid = mid;
        this.comment = comment;
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