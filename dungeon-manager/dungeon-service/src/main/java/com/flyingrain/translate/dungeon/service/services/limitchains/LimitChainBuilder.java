package com.flyingrain.translate.dungeon.service.services.limitchains;

import com.flyingrain.translate.dungeon.api.requests.JoinRequest;
import com.flyingrain.translate.dungeon.service.services.common.ActiveEnum;
import com.flyingrain.translate.dungeon.service.services.common.ExceptionEnum;
import com.flyingrain.translate.dungeon.service.services.dao.mapper.DungeonInstanceMapper;
import com.flyingrain.translate.dungeon.service.services.dao.mapper.DungeonRuleMapper;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonInstanceModel;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleModel;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.Limit;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.LimitChainExecutor;
import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.plan.api.intf.PlanManagerResource;
import com.flyingrain.translate.plan.api.intf.TaskResource;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.TaskSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by wally on 10/26/17.
 */
@Component
public class LimitChainBuilder {

    private Logger logger = LoggerFactory.getLogger(LimitChainBuilder.class);

    @Autowired
    private PlanManagerResource planManagerResource;

    @Autowired
    private TaskResource taskResource;

    @Autowired
    private DungeonRuleMapper dungeonRuleMapper;

    @Autowired
    private DungeonInstanceMapper instanceMapper;

    @Autowired
    private Map<String, Limit> dungeonLimits;

    /**
     * 根据加入副本请求构建判断
     *
     * @param joinRequest
     * @return
     */
    public LimitChainExecutor build(JoinRequest joinRequest) {
        logger.info("start to build dungeon limit chain,dungeonInstanceId :[{}]", joinRequest.getDungeonInstanceId());
        Plan plan = planManagerResource.getUserPlan(joinRequest.getUserId() + "");
        TaskSummary taskSummary = null;


        DungeonInstanceModel instanceModel = instanceMapper.dungeonInstanceById(joinRequest.getDungeonInstanceId());
        List<DungeonRuleModel> dungeonRuleModels = dungeonRuleMapper.getRulesByDungeonId(instanceMapper.dungeonId(joinRequest.getDungeonInstanceId()), ActiveEnum.ACTIVE.ordinal());
        Map<Integer, Optional<String>> rules = dungeonRuleModels.stream().collect(Collectors.groupingBy(DungeonRuleModel::getRule_type, Collectors.mapping(DungeonRuleModel::getRule_param, Collectors.reducing((r, l) -> r + l))));
        LinkedList<Limit> limitChain = new LinkedList<>();
        logger.info("start generate chain!");
        dungeonRuleModels.forEach(model -> limitChain.add(dungeonLimits.get(model.getRule())));
        return new LimitChainExecutor(rules, plan, taskSummary, limitChain);
    }

}
