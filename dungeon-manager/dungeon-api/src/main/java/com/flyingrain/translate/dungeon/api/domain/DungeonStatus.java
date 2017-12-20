package com.flyingrain.translate.dungeon.api.domain;

public  enum DungeonStatus {

    PREPARE(10,""),
    DOING(20,""),
    FINISHED(30,""),
    TERMINATION(90,"")
    ;
    private int status;

    private String desc;

    DungeonStatus(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
