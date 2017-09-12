package com.flyingrain.translate.dungeon.service.services;

import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonConsistModel;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonResourceModel;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleModel;

/**
 * Created by Uni on 2017/9/11.
 */
public interface DungeonConsistService {

    /**
     * 组合副本和规则
     * @param dungeonResourceModel
     * @param dungeonRuleModel
     * @return
     */
    DungeonConsistModel getDungeonConsist(DungeonResourceModel dungeonResourceModel, DungeonRuleModel dungeonRuleModel);


}
