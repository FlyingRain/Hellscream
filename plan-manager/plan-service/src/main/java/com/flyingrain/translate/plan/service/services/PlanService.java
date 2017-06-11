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

    /**
     * 查看用户所有计划
     * @param planId
     * @param userId
     * @return
     */
    List<Plan> queryPlan(Integer planId,int userId);

    /**
     * 查询指定状态的计划
     * @param userId
     * @param status
     * @return
     */
    List<Plan> querySpecificPlan(int userId,int status);

    int modifyPlan(PlanRequest planRequest);

}
