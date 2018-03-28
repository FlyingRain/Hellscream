package com.flyingrain.translate.dungeon.service.impl;

import com.flyingrain.translate.dungeon.api.DungeonResources;
import com.flyingrain.translate.dungeon.api.domain.DungeonInstance;
import com.flyingrain.translate.dungeon.api.requests.DungeonQueryRequest;
import com.flyingrain.translate.dungeon.api.requests.JoinRequest;
import com.flyingrain.translate.dungeon.api.requests.UploadTestRequest;
import com.flyingrain.translate.dungeon.api.responses.DungeonPlanResult;
import com.flyingrain.translate.dungeon.api.responses.JoinResult;
import com.flyingrain.translate.dungeon.api.responses.UploadResult;
import com.flyingrain.translate.dungeon.service.services.DungeonService;
import com.flyingrain.translate.framework.annotaions.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wally on 17-9-10.
 */
@Component
@Resource
public class DungeonResourcesImpl implements DungeonResources {

    private Logger logger = LoggerFactory.getLogger(DungeonResourcesImpl.class);

    @Autowired
    private DungeonService dungeonService;

    @Override
    public DungeonInstance dungeonInstanceById(Integer instanceId) {
        return null;
    }

    @Override
    public List<DungeonInstance> getDungeons(DungeonQueryRequest queryRequest) {
        logger.info("dungeon query request:[{}]", queryRequest);
        return dungeonService.getDungeons(queryRequest);
    }

    @Override
    public JoinResult joinDungeon(JoinRequest joinRequest) {
        return dungeonService.joinDungeon(joinRequest);
    }

    @Override
    public DungeonPlanResult getDungeonPlan(Integer planId, Integer userId) {
        logger.info("query user:[{}],dungeon status", userId);
        return dungeonService.dungeonPlan(userId, planId);
    }

    @Override
    public UploadResult uploadTest(UploadTestRequest request) {
        return null;
    }
}
