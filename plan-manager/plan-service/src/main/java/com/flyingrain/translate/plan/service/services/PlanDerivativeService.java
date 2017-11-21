package com.flyingrain.translate.plan.service.services;

/**
 * Created by wally on 11/21/17.
 */
public interface PlanDerivativeService {


    /**
     * 获取剩余天数
     * @param planId
     * @return
     */
    int getLeftDay(int planId);
}
