package com.flyingrain.translate.plan.service.services.impl;

import com.flyingrain.translate.plan.api.request.PlanRequest;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.service.services.PlanService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wally on 4/25/17.
 */
@Component
public class PlanServiceImpl implements PlanService{

    @Override
    public int makePlan(PlanRequest planRequest) {
        return 0;
    }

    @Override
    public List<Plan> queryPlan(Integer planId) {
        return null;
    }
}
