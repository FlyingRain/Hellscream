package com.flyingrain.translate.dungeon.service.services.limitchains;

import com.flyingrain.translate.dungeon.api.requests.JoinRequest;
import com.flyingrain.translate.dungeon.service.services.common.ActiveEnum;
import com.flyingrain.translate.dungeon.service.services.common.LimitConstant;
import com.flyingrain.translate.dungeon.service.services.dao.mapper.DungeonInstanceMapper;
import com.flyingrain.translate.dungeon.service.services.dao.mapper.DungeonRuleMapper;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonInstanceModel;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleModel;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.Limit;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.LimitChainExecutor;
import com.flyingrain.translate.plan.api.intf.PlanManagerResource;
import com.flyingrain.translate.plan.api.intf.TaskResource;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.TaskSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created on 18-3-24.
 *
 * @author wally
 */

@Component
public class LimitChainsDirector {

    private Logger logger = LoggerFactory.getLogger(LimitChainsDirector.class);

    private WeakHashMap<Integer, LimitChainExecutor> limitChainCache = new WeakHashMap<>();

    @Autowired
    private PlanManagerResource planManagerResource;

    @Autowired
    private TaskResource taskResource;

    @Autowired
    private DungeonRuleMapper dungeonRuleMapper;

    @Autowired
    private DungeonInstanceMapper instanceMapper;

    @Autowired
    private LimitChainsBuilder limitChainBuilder;

    public LimitChainExecutor buildChain(JoinRequest joinRequest) {
        logger.info("start build limit chain!dungeonInstanceId is [{}]", joinRequest.getDungeonInstanceId());
        DungeonInstanceModel instanceModel = instanceMapper.dungeonInstanceById(joinRequest.getDungeonInstanceId());
        LimitChainExecutor executor = limitChainCache.get(instanceModel.getDungeon_source());
        if (executor != null) {
            logger.info("there is cache,return cached chain!");
            return executor;
        }
        initContext(joinRequest, instanceModel);
        executor = new LimitChainExecutor(limitChainBuilder.buildPreChain(), limitChainBuilder.buildRuleChain(), limitChainBuilder.buildPostChain());
        logger.info("build limitChains success!start to cache it: dungeonId:[{}]", instanceModel.getDungeon_source());
        limitChainCache.put(instanceModel.getDungeon_source(), executor);
        return executor;

    }

    private void initContext(JoinRequest joinRequest, DungeonInstanceModel instanceModel) {
        LimitContext.put(LimitConstant.DUNGEONINSTANCE, instanceModel);
        logger.info("obtain plan info by userId:[{}]", joinRequest.getPlanId());
        Plan plan = planManagerResource.getUserPlan(String.valueOf(joinRequest.getUserId()));
        LimitContext.put(LimitConstant.PLAN, plan);
        TaskSummary summary = taskResource.getTaskSummary(joinRequest.getPlanId(), joinRequest.getUserId(), null);
        logger.info("get task summary![{}]", summary);
        LimitContext.put(LimitConstant.SUMMARY, summary);
        List<DungeonRuleModel> rules = dungeonRuleMapper.getRulesByDungeonId(instanceModel.getDungeon_source(), ActiveEnum.ACTIVE.ordinal());
        logger.info("get rules of dungeon:[{}]", rules.size());
        LimitContext.put(LimitConstant.RULES, rules);
    }


}
