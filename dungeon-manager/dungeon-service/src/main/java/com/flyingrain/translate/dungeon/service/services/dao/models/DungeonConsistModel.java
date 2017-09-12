package com.flyingrain.translate.dungeon.service.services.dao.models;

/**
 * Created by Uni on 2017/9/11.
 */
public class DungeonConsistModel {

    /**
     * 副本静态资源
     */
    private DungeonResourceModel dungeonResourceModel;

    /**
     * 副本动态资源
     */
    private DungeonRuleModel dungeonRuleModel;

    public DungeonResourceModel getDungeonResourceModel() {
        return dungeonResourceModel;
    }

    public void setDungeonResourceModel(DungeonResourceModel dungeonResourceModel) {
        this.dungeonResourceModel = dungeonResourceModel;
    }

    public DungeonRuleModel getDungeonRuleModel() {
        return dungeonRuleModel;
    }

    public void setDungeonRuleModel(DungeonRuleModel dungeonRuleModel) {
        this.dungeonRuleModel = dungeonRuleModel;
    }
}
