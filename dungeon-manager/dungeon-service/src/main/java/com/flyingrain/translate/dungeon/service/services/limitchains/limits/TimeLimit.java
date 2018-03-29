package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.dungeon.service.services.common.LimitConstant;
import com.flyingrain.translate.dungeon.service.services.limitchains.LimitContext;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.models.TimeLimitModel;
import com.flyingrain.translate.framework.lang.utils.DateUtil;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.PlanType;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class TimeLimit extends AbstractLimit<TimeLimitModel> {

    private Logger logger = LoggerFactory.getLogger(TimeLimit.class);

    public TimeLimit(String param) {
        super(param);
    }

    public TimeLimit(TimeLimitModel limitModel) {
        super(limitModel);
    }

    public TimeLimit(Date startDate, Date endDate) {
        super(new TimeLimitModel(startDate, endDate));
    }

    @Override
    public Class<TimeLimitModel> getLimitClass() {
        return TimeLimitModel.class;
    }


    @Override
    public LimitResult determine() {
        Plan plan = (Plan) LimitContext.get(LimitConstant.PLAN);
        if (DateUtils.truncatedCompareTo(limitModel.getStartDate(), new Date(), Calendar.DATE) > 0) {
            logger.info("the dungeon not started!");
            return LimitResult.fail("副本尚未开启");
        }
        if (plan.getPlanType() == PlanType.BYDEADLINE.getType()) {
            if (DateUtils.truncatedCompareTo(limitModel.getEndDate(), plan.getDeadline(), Calendar.DATE) < 0) {
                return LimitResult.fail("the plan's deadline is earlier than the endTime of the dungeon!");
            }
        } else if (plan.getPlanType() == PlanType.BYNUMBER.getType()) {
            int leftDays = (int) LimitContext.get(LimitConstant.LEFTDAY);
            int dungeonLeftDays = (int) ChronoUnit.DAYS.between(DateUtil.dateToLocalDate(new Date()), DateUtil.dateToLocalDate(limitModel.getEndDate()));
            if (leftDays < dungeonLeftDays) {
                logger.warn("The plan left days [{}] is less than dungeon left days[{}].planId is [{}]", new Object[]{leftDays, dungeonLeftDays, plan.getId()});
                return LimitResult.fail("当前计划剩余时间不足");
            }
        }
        return LimitResult.success();
    }
}
