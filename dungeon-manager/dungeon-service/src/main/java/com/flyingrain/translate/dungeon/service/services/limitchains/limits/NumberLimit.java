package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.dungeon.service.services.common.LimitEnum;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.models.NumberLimitModel;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.TaskSummary;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 11/6/17.
 */
@Component
public class NumberLimit extends AbstractLimit<NumberLimitModel>{
    @Override
    public int getLimitName() {
        return LimitEnum.MEMBERNUM.getLimitName();
    }

    @Override
    public Class<NumberLimitModel> getLimitClass() {
        return null;
    }

    @Override
    public LimitResult judge(NumberLimitModel limitObject, Plan plan, TaskSummary summary) {
        //TODO limit of dungeon members
        return LimitResult.success();
    }
}
