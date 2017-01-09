package com.musicbeat.web.model;

public class AlbumComment {
    private Integer id;

    private Integer uid;

    private Integer aid;

    private String comment;

    public AlbumComment(Integer id, Integer uid, Integer aid, String comment) {
        this.id = id;
        this.uid = uid;
        this.aid = aid;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUid() {
        return uid;
    }

    public Integer getAid() {
        return aid;
    }

    public String getComment() {
        return comment;
    }
}