package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.dungeon.service.services.common.LimitConstant;
import com.flyingrain.translate.dungeon.service.services.limitchains.LimitContext;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.models.PlanTypeLimitModel;
import com.flyingrain.translate.plan.api.response.Plan;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 11/6/17.
 */
@Component
public class PlanTypeLimit extends AbstractLimit<PlanTypeLimitModel> {

    public PlanTypeLimit(String param) {
        super(param);
    }

    public PlanTypeLimit(PlanTypeLimitModel limitModel) {
        super(limitModel);
    }

    @Override
    public Class<PlanTypeLimitModel> getLimitClass() {
        return PlanTypeLimitModel.class;
    }


    @Override
    public LimitResult determine() {
        Plan plan = (Plan) LimitContext.get(LimitConstant.PLAN);
        if (limitModel == null || limitModel.getPlanType() == plan.getPlanType()) {
            return LimitResult.success();
        }
        return LimitResult.fail("计划类型不符合要求;");

    }
}
