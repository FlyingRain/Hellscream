package com.flyingrain.translate.plan.service.services;

import com.flyingrain.translate.plan.api.request.PlanRequest;
import com.flyingrain.translate.plan.api.response.Plan;

import java.util.List;

/**
 * Created by wally on 4/25/17.
 */
public interface PlanService {

    int makePlan(PlanRequest planRequest);

    List<Plan> queryPlan(Integer planId);

}
