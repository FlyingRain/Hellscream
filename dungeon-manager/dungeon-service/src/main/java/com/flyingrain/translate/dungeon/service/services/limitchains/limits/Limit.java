package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.TaskSummary;

import java.util.Map;

/**
 * 加入副本限制条件
 * Created by wally on 10/30/17.
 */
public interface Limit {

    /**
     * 决定是否符合
     * @return
     */
    LimitResult determine(Map<String,String> limits, Plan plan, TaskSummary summary);

}