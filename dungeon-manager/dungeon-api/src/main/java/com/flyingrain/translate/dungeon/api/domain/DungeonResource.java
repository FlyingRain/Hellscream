package com.flyingrain.translate.dungeon.api.domain;

import java.io.Serializable;

/**
 * Created by Uni on 2017/9/9.
 */
public class DungeonResource implements Serializable {

    private int id;             //副本id

    private String title;       //副本标题

    private String desc;        //副本描述

    private String imgs;        //副本图片

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }
}
