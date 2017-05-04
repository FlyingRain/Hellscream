package com.flyingrain.translate.plan.service.services;

import java.util.Date;

/**
 * Created by wally on 5/4/17.
 */
public interface PlanGenerator {

    /**
     * 生成已返回计划状态的下一天计划
      * @return
     */
    String generatePlans();

    String generatePlan(String userId, String planId, Date planDate);

}
