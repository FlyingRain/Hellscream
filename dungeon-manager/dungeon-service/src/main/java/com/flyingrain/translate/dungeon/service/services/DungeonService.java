package com.flyingrain.translate.dungeon.service.services;

import com.flyingrain.translate.dungeon.api.domain.DungeonInstance;
import com.flyingrain.translate.dungeon.api.requests.DungeonQueryRequest;
import com.flyingrain.translate.dungeon.api.requests.JoinRequest;
import com.flyingrain.translate.dungeon.api.responses.DungeonPlanResult;
import com.flyingrain.translate.dungeon.api.responses.JoinResult;

import java.util.List;

/**
 * Created by wally on 17-9-10.
 */
public interface DungeonService {


    /**
     * 实例
     * @param dungeonInstanceId
     * @return
     */
    DungeonInstance getInstanceById(Integer dungeonInstanceId);

    /**
     * 根据条件查询副本
     * @param queryRequest
     * @return
     */
    List<DungeonInstance> getDungeons(DungeonQueryRequest queryRequest);

    /**
     * 加入副本
     * @param request
     * @return
     */
    JoinResult joinDungeon(JoinRequest request);

    /**
     * 获取用户计划在副本中的状态
     * @return
     */
    DungeonPlanResult dungeonPlan(Integer userId,Integer planId);
}
