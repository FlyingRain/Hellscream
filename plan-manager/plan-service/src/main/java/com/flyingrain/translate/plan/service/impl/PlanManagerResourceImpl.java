package com.flyingrain.translate.plan.service.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.plan.api.intf.PlanManagerResource;
import com.flyingrain.translate.plan.api.request.PlanRequest;
import com.flyingrain.translate.plan.api.response.ModifyResult;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.service.common.PlanExceptionCode;
import com.flyingrain.translate.plan.service.services.PlanService;
import com.flyingrain.translate.plan.service.services.common.PlanStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by wally on 4/25/17.
 */
@Component
@Resource
public class PlanManagerResourceImpl implements PlanManagerResource {

    private Logger logger = LoggerFactory.getLogger(PlanManagerResourceImpl.class);
    @Autowired
    private PlanService planService;

    @Override
    public Integer makePlan(PlanRequest planRequest) {
        logger.info("get make plan request : [{}]", planRequest);
        return planService.makePlan(planRequest);

    }

    @Override
    public Plan getUserPlan(String userId) {
        List<Plan> plans = planService.querySpecificPlan(Integer.parseInt(userId), PlanStatus.UNDERWAY.status);
        return CollectionUtils.isEmpty(plans) ? new Plan() : plans.get(0);
    }

    @Override
    public List<Plan> queryPlan(Integer planId, Integer userId) {
        //参数校验
        if (planId == null && userId == null) {
            logger.info("query param is null!");
            throw new FlyException(PlanExceptionCode.PARAM_INVALID.getCode(), PlanExceptionCode.PARAM_INVALID.getMsg());
        }
        return planService.queryPlan(planId, userId);
    }

    @Override
    public ModifyResult modifyPlan(PlanRequest planRequest) {
        logger.info("start to update planRequest![{}]", planRequest);
        int i = planService.modifyPlan(planRequest);
        if (i == 0) {
            throw new FlyException(PlanExceptionCode.PARAM_INVALID.getCode(), PlanExceptionCode.PARAM_INVALID.getMsg());
        }
        ModifyResult modifyResult = new ModifyResult();
        modifyResult.setMsg("更新成功");
        modifyResult.setStatus("00");
        return modifyResult;
    }
}
