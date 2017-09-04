package com.flyingrain.translate.dungeon.api.model;

public class DungeonRequest {

    private String Id;

    private String title;

    private String desc;

    private DungeonLimit limit;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public DungeonLimit getLimit() {
        return limit;
    }

    public void setLimit(DungeonLimit limit) {
        this.limit = limit;
    }
}
