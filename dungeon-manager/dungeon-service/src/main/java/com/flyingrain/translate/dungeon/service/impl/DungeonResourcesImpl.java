package com.flyingrain.translate.dungeon.service.impl;

import com.flyingrain.translate.dungeon.api.DungeonResources;
import com.flyingrain.translate.dungeon.api.domain.DungeonInstance;
import com.flyingrain.translate.dungeon.api.requests.DungeonQueryRequest;
import com.flyingrain.translate.dungeon.api.requests.JoinRequest;
import com.flyingrain.translate.dungeon.api.requests.UploadTestRequest;
import com.flyingrain.translate.dungeon.api.responses.DungeonPlanResult;
import com.flyingrain.translate.dungeon.api.responses.JoinResult;
import com.flyingrain.translate.dungeon.api.responses.UploadResult;
import com.flyingrain.translate.framework.annotaions.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wally on 17-9-10.
 */
@Component
@Resource
public class DungeonResourcesImpl implements DungeonResources{


    @Override
    public List<DungeonInstance> getDungeons(DungeonQueryRequest queryRequest) {
        return null;
    }

    @Override
    public JoinResult joinDungeon(JoinRequest joinRequest) {
        return null;
    }

    @Override
    public DungeonPlanResult getDungeonPlan(Integer planId, Integer userId) {
        return null;
    }

    @Override
    public UploadResult uploadTest(UploadTestRequest request) {
        return null;
    }
}
