package com.flyingrain.translate.dungeon.api.domain;

import java.io.Serializable;

/**
 * Created by Uni on 2017/9/9.
 */
public class DungeonConsist implements Serializable {

    private DungeonResource dungeonResource;

    private DungeonRole dungeonRole;

    public DungeonResource getDungeonResource() {
        return dungeonResource;
    }

    public void setDungeonResource(DungeonResource dungeonResource) {
        this.dungeonResource = dungeonResource;
    }

    public DungeonRole getDungeonRole() {
        return dungeonRole;
    }

    public void setDungeonRole(DungeonRole dungeonRole) {
        this.dungeonRole = dungeonRole;
    }
}
