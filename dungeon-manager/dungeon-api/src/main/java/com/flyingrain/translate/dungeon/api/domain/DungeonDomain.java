package com.flyingrain.translate.dungeon.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * 副本模型
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DungeonDomain {

    /**
     * 副本Id
     */
    private String Id;
    /**
     * 副本名称
     */
    private String title;

    /**
     * 状态
     */
    private String status;
    /**
     * 副本描述
     */
    private String desc;
    /**
     * 副本限制
     */
    private List<DungeonLimit> limits;

    /**
     * 副本图片列表
     */
    private List<String> imgPaths;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImgPaths() {
        return imgPaths;
    }

    public void setImgPaths(List<String> imgPaths) {
        this.imgPaths = imgPaths;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DungeonLimit> getLimits() {

        return limits;
    }

    public void setLimits(List<DungeonLimit> limits) {
        this.limits = limits;
    }
}
