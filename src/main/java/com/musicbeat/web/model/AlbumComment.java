package com.musicbeat.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AlbumComment implements Serializable {

    private static final long serialVersionUID = 7100318035164693590L;

    private Integer id;

    private Integer uid;

    private Integer aid;

    private String comment;

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();

        list.add(id.toString());
        list.add(uid.toString());
        list.add(aid.toString());
        list.add(comment);

        return list.toString();
    }

    public AlbumComment(Integer id, Integer uid, Integer aid, String comment) {
        this.id = id;
        this.uid = uid;
        this.aid = aid;
        this.comment = comment == null ? null : comment.trim();
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