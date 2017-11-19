package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.dungeon.service.services.common.LimitEnum;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.models.TimeLimitModel;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.PlanType;
import com.flyingrain.translate.plan.api.response.TaskSummary;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;

public class TimeLimit extends AbstractLimit<TimeLimitModel>{
    @Override
    public String getLimitName() {
        return LimitEnum.TIME.getLimitName();
    }

    @Override
    public Class<TimeLimitModel> getLimitClass() {
        return TimeLimitModel.class;
    }

    @Override
    public LimitResult judge(TimeLimitModel limitObject, Plan plan, TaskSummary summary) {
        if(plan.getPlanType()== PlanType.BYDEADLINE.getType()){
            if(DateUtils.truncatedCompareTo(limitObject.getEndDate(),plan.getDeadline(), Calendar.DATE)<0){
                LimitResult.fail("the plan's deadline is earlier than the endTime of the dungeon!");
            }
        }else if(plan.getPlanType()==PlanType.BYNUMBER.getType()){

        }
        return null;
    }
}
