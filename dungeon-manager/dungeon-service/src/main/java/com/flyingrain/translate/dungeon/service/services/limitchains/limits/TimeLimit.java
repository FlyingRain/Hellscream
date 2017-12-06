package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.dungeon.service.services.common.LimitEnum;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.models.TimeLimitModel;
import com.flyingrain.translate.framework.lang.utils.DateUtil;
import com.flyingrain.translate.plan.api.intf.PlanDerivativeResource;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.PlanType;
import com.flyingrain.translate.plan.api.response.TaskSummary;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
@Component
public class TimeLimit extends AbstractLimit<TimeLimitModel> {

    private Logger logger = LoggerFactory.getLogger(TimeLimit.class);

    @Autowired
    private PlanDerivativeResource derivativeResource;


    @Override
    public int getLimitName() {
        return LimitEnum.TIME.getLimitName();
    }

    @Override
    public Class<TimeLimitModel> getLimitClass() {
        return TimeLimitModel.class;
    }

    @Override
    public LimitResult judge(TimeLimitModel limitObject, Plan plan, TaskSummary summary) {
        if (plan.getPlanType() == PlanType.BYDEADLINE.getType()) {
            if (DateUtils.truncatedCompareTo(limitObject.getEndDate(), plan.getDeadline(), Calendar.DATE) < 0) {
                return LimitResult.fail("the plan's deadline is earlier than the endTime of the dungeon!");
            }
        } else if (plan.getPlanType() == PlanType.BYNUMBER.getType()) {
            int leftDays = derivativeResource.getPlanLeftDay(plan.getId());
            int dungeonLeftDays = (int) ChronoUnit.DAYS.between(DateUtil.dateToLocalDate(new Date()), DateUtil.dateToLocalDate(limitObject.getEndDate()));
            if (leftDays < dungeonLeftDays) {
                logger.warn("The plan left days [{}] is less than dungeon left days[{}].planId is [{}]",new Object[]{leftDays,dungeonLeftDays,plan.getId()});
                return LimitResult.fail("当前计划剩余时间不足");
            }
        }
        return LimitResult.success();
    }
}
