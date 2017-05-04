package com.flyingrain.translate.plan.service.services;

import com.flyingrain.translate.plan.api.intf.PlanManagerResource;
import com.flyingrain.translate.plan.api.request.PlanRequest;
import com.flyingrain.translate.plan.api.response.Plan;

import java.util.List;

/**
 * Created by wally on 4/25/17.
 */
public interface PlanService {
    /**
     * 生成计划
     * @param planRequest
     * @return
     */
    Integer makePlan(PlanRequest planRequest);

    List<Plan> queryPlan(Integer planId,int userId);

    int modifyPlan(PlanRequest planRequest);

}
