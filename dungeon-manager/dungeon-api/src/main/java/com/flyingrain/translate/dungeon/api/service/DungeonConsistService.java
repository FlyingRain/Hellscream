package com.flyingrain.translate.dungeon.api.service;

import com.flyingrain.translate.dungeon.api.domain.DungeonConsist;
import com.flyingrain.translate.dungeon.api.domain.DungeonResource;
import com.flyingrain.translate.dungeon.api.domain.DungeonRole;

/**
 * Created by Uni on 2017/9/9.
 */
public interface DungeonConsistService {

    DungeonConsist getDungeonConsist(DungeonResource dungeonResource, DungeonRole dungeonRole);
}
