package com.flyingrain.translate.plan.service.services;

import com.flyingrain.translate.plan.api.request.PlanRequest;
import com.flyingrain.translate.plan.service.services.dao.model.PlanModel;

/**
 * 根据计划请求，生成对应的计划
 * Created by wally on 6/19/17.
 */
public interface PlanGenerator {

    PlanModel generatePlan(PlanRequest request);
}
