package com.flyingrain.translate.dungeon.service.services.limitchains;

import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonInstanceModel;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleModel;

import java.util.List;

/**
 * Created on 3/29/18.
 *
 * @author wally
 */
public class LimitChainRequest {

    private DungeonInstanceModel instanceModel;

    private List<DungeonRuleModel> ruleModels;

    private int userId;

    private int planId;

    public DungeonInstanceModel getInstanceModel() {
        return instanceModel;
    }

    public void setInstanceModel(DungeonInstanceModel instanceModel) {
        this.instanceModel = instanceModel;
    }

    public List<DungeonRuleModel> getRuleModels() {
        return ruleModels;
    }

    public void setRuleModels(List<DungeonRuleModel> ruleModels) {
        this.ruleModels = ruleModels;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    @Override
    public String toString() {
        return "LimitChainRequest{" +
                "instanceModel=" + instanceModel +
                ", ruleModels=" + ruleModels +
                ", userId=" + userId +
                ", planId=" + planId +
                '}';
    }
}
