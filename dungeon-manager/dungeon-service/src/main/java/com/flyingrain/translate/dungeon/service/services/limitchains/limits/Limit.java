package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.dungeon.api.domain.DungeonDomain;
import com.flyingrain.translate.plan.api.response.Plan;

/**
 * 加入副本限制条件
 * Created by wally on 10/30/17.
 */
public interface Limit {

    /**
     * 决定是否符合
     * @return
     */
    LimitResult determine(DungeonDomain dungeonDomain, Plan plan);

}