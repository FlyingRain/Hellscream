package com.flyingrain.translate.dungeon.api.domain;

import java.io.Serializable;

/**
 * Created by Uni on 2017/9/9.
 */
public class DungeonRelation implements Serializable {

    private int id;

    private int dungeon_id;     //副本id

    private int role_id;        //副本动态id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDungeon_id() {
        return dungeon_id;
    }

    public void setDungeon_id(int dungeon_id) {
        this.dungeon_id = dungeon_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
