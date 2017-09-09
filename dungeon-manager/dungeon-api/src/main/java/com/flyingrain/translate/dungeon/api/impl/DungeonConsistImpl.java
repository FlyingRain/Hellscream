package com.flyingrain.translate.dungeon.api.impl;

import com.flyingrain.translate.dungeon.api.domain.DungeonConsist;
import com.flyingrain.translate.dungeon.api.domain.DungeonResource;
import com.flyingrain.translate.dungeon.api.domain.DungeonRole;
import com.flyingrain.translate.dungeon.api.service.DungeonConsistService;
import org.springframework.stereotype.Component;

/**
 * Created by Uni on 2017/9/9.
 */
@Component
public class DungeonConsistImpl implements DungeonConsistService {

    @Override
    public DungeonConsist getDungeonConsist(DungeonResource dungeonResource, DungeonRole dungeonRole) {
        DungeonConsist dungeonConsist = new DungeonConsist();
        dungeonConsist.setDungeonResource(dungeonResource);
        dungeonConsist.setDungeonRole(dungeonRole);
        return dungeonConsist;
    }
}
