package com.flyingrain.translate.dungeon.service.services.impl;

import com.flyingrain.translate.dungeon.service.services.DungeonConsistService;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonConsistModel;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonResourceModel;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleModel;
import org.springframework.stereotype.Component;

/**
 * Created by Uni on 2017/9/11.
 */
@Component
public class DungeonConsistImpl implements DungeonConsistService {

    @Override
    public DungeonConsistModel getDungeonConsist(DungeonResourceModel dungeonResourceModel, DungeonRuleModel dungeonRuleModel) {

        DungeonConsistModel dungeonConsistModel = new DungeonConsistModel();
        dungeonConsistModel.setDungeonResourceModel(dungeonResourceModel);
        dungeonConsistModel.setDungeonRuleModel(dungeonRuleModel);
        return dungeonConsistModel;

    }
}
