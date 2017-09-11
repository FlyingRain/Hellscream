package com.flyingrain.translate.dungeon.service.services.dao.models;

import java.util.Date;

/**
 * 副本模板
 * Created by wally on 9/11/17.
 */
public class DungeonResourceModel {

    /**
     * 主键
     */
    private int id;
    /**
     * 副本标题
     */
    private String title;
    /**
     * 副本描述
     */
    private String desc;
    /**
     * 副本图片资源地址
     */
    private String imgs;
    /**
     * 添加时间
     */
    private Date data_added;
    /**
     * 最后修改时间
     */
    private Date last_modified;

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

    public Date getData_added() {
        return data_added;
    }

    public void setData_added(Date data_added) {
        this.data_added = data_added;
    }

    public Date getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Date last_modified) {
        this.last_modified = last_modified;
    }
}
