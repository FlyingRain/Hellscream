package com.flyingrain.translate.dungeon.service.services.impl;

import com.flyingrain.translate.dungeon.api.domain.DungeonInstance;
import com.flyingrain.translate.dungeon.api.requests.DungeonQueryRequest;
import com.flyingrain.translate.dungeon.api.requests.JoinRequest;
import com.flyingrain.translate.dungeon.api.responses.JoinResult;
import com.flyingrain.translate.dungeon.service.services.DungeonService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wally on 10/26/17.
 */
@Component
public class DungeonServiceImpl implements DungeonService{

    @Override
    public List<DungeonInstance> getDungeons(DungeonQueryRequest queryRequest) {
        return null;
    }

    @Override
    public JoinResult joinDungeon(JoinRequest request) {
        return null;
    }
}
