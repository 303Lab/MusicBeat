package com.musicbeat.web.model.viewModel;

/**
 * Created by Administrator on 2017/2/21.
 */
public class MusicViewModel {
    private Integer id;
    private String name;
    private String lyrics;
    private String link;

    /*专辑图片*/
    private String aPicture;
    private String aName;

    /*歌手姓名*/
    private String sName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getaPicture() {
        return aPicture;
    }

    public void setaPicture(String aPicture) {
        this.aPicture = aPicture;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
}
