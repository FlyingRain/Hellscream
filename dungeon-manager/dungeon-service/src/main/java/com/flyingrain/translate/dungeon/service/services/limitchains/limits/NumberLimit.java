package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.dungeon.service.services.limitchains.limits.models.NumberLimitModel;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.TaskSummary;

/**
 * Created by wally on 11/6/17.
 */
public class NumberLimit extends AbstractLimit<NumberLimitModel>{
    @Override
    public String getLimitName() {
        return null;
    }

    @Override
    public Class<NumberLimitModel> getLimitClass() {
        return null;
    }

    @Override
    public LimitResult judge(NumberLimitModel limitObject, Plan plan, TaskSummary summary) {
        return null;
    }
}
