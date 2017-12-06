package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.dungeon.service.services.common.LimitEnum;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.models.PlanTypeLimitModel;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.TaskSummary;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 11/6/17.
 */
@Component
public class PlanTypeLimit extends AbstractLimit<PlanTypeLimitModel> {
    @Override
    public int getLimitName() {
        return LimitEnum.PLANTYPE.getLimitName();
    }

    @Override
    public Class<PlanTypeLimitModel> getLimitClass() {
        return PlanTypeLimitModel.class;
    }

    @Override
    public LimitResult judge(PlanTypeLimitModel limitObject, Plan plan, TaskSummary summary) {
        if (limitObject == null || limitObject.getPlanType() == plan.getPlanType()) {
            return LimitResult.success();
        }
        return LimitResult.fail("计划类型不符合要求;");

    }
}
