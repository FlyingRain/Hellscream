package com.flyingrain.translate.dungeon.service.services.limitchains;

import com.flyingrain.translate.dungeon.service.services.common.LimitConstant;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonInstanceModel;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleModel;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.Limit;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.ParamInitLimit;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.TimeLimit;
import com.flyingrain.translate.plan.api.intf.PlanDerivativeResource;
import com.flyingrain.translate.plan.api.intf.PlanManagerResource;
import com.flyingrain.translate.plan.api.intf.TaskResource;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.TaskSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wally on 18-3-18.
 */
@Component
public class LimitChainsBuilderImpl implements LimitChainsBuilder {

    private Logger logger = LoggerFactory.getLogger(LimitChainsBuilderImpl.class);
    @Autowired
    private PlanManagerResource planManagerResource;

    @Autowired
    private TaskResource taskResource;

    @Autowired
    private PlanDerivativeResource derivativeResource;


    @Override
    public List<Limit> buildPreChain() {
        LimitChainRequest request = (LimitChainRequest) LimitContext.get(LimitConstant.PARAM);
        DungeonInstanceModel instanceModel = request.getInstanceModel();
        Plan plan = planManagerResource.getUserPlan(request.getUserId() + "");
        TaskSummary taskSummary = taskResource.getTaskSummary(request.getPlanId(), request.getUserId(), null);
        int leftDay = derivativeResource.getPlanLeftDay(request.getPlanId());
        ParamInitLimit paramInitLimit = new ParamInitLimit(plan, taskSummary, leftDay);
        List<Limit> preChain = new LinkedList<>();
        TimeLimit timeLimit = new TimeLimit(instanceModel.getEnroll_time(), instanceModel.getEnd_time());
        preChain.add(paramInitLimit);
        preChain.add(timeLimit);
        logger.info("build pre limitChain!");
        return preChain;
    }

    @Override
    public List<Limit> buildRuleChain() {
        LinkedList<Limit> ruleLimits = new LinkedList<>();
        LimitChainRequest request = (LimitChainRequest) LimitContext.get(LimitConstant.PARAM);
        List<DungeonRuleModel> ruleModels = request.getRuleModels();


        return null;
    }

    @Override
    public List<Limit> buildPostChain() {
        return null;
    }
}
