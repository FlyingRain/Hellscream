package com.flyingrain.translate.dungeon.service.services.dao.models;

import java.util.Date;

/**
 *
 * 副本开关
 * Created by wally on 9/11/17.
 */
public class DungeonSwitchModel {

    private int dungeonId;

    private int status;

    private Date data_added;

    private Date last_modified;

    public int getDungeonId() {
        return dungeonId;
    }

    public void setDungeonId(int dungeonId) {
        this.dungeonId = dungeonId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
