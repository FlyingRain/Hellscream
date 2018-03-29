package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.dungeon.service.services.common.ExceptionEnum;
import com.flyingrain.translate.dungeon.service.services.common.LimitConstant;
import com.flyingrain.translate.dungeon.service.services.limitchains.LimitContext;
import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.TaskSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 3/29/18.
 *
 * @author wally
 */
public class ParamInitLimit extends AbstractLimit {

    private Logger logger = LoggerFactory.getLogger(ParamInitLimit.class);

    private final Plan plan;

    private final TaskSummary summary;

    private final int leftDay;


    public ParamInitLimit(Plan plan, TaskSummary summary, int leftDay) {
        super(new Object());
        this.plan = plan;
        this.leftDay = leftDay;
        this.summary = summary;
    }

    @Override
    public Class getLimitClass() {
        return null;
    }

    @Override
    public LimitResult determine() {
        try {
            putifNotNull(LimitConstant.PLAN, plan);
            putifNotNull(LimitConstant.SUMMARY, summary);
            LimitContext.put(LimitConstant.LEFTDAY, leftDay);
        } catch (Exception e) {
            logger.error("sys happen exception!", e);
            if (e instanceof FlyException) {
                return LimitResult.fail(((FlyException) e).getExCode());
            }
        }
        return LimitResult.success();
    }

    private void putifNotNull(String key, Object value) {
        if (value == null) {
            throw new FlyException(ExceptionEnum.NOTEXIT.getCode(), key + ExceptionEnum.NOTEXIT.getDesc());
        }
        logger.info("get [{}] ,values is :[{}]", key, value);
        LimitContext.put(key, value);

    }
}
