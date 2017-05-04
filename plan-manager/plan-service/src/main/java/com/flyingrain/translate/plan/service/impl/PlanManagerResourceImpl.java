package com.flyingrain.translate.plan.service.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.plan.api.intf.PlanManagerResource;
import com.flyingrain.translate.plan.api.request.PlanRequest;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.Result;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wally on 4/25/17.
 */
@Component
@Resource
public class PlanManagerResourceImpl implements PlanManagerResource{


    @Override
    public Result<Integer> makePlan(PlanRequest planRequest) {
        return null;
    }

    @Override
    public Result<List<Plan>> queryPlan(int planId,int userId) {
        return null;
    }
}
