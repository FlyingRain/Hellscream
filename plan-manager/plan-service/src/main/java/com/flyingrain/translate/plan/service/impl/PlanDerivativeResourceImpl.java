package com.flyingrain.translate.plan.service.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.plan.api.intf.PlanDerivativeResource;
import com.flyingrain.translate.plan.service.services.PlanDerivativeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 11/21/17.
 */
@Resource
@Component
public class PlanDerivativeResourceImpl implements PlanDerivativeResource{

    private Logger logger = LoggerFactory.getLogger(PlanDerivativeResourceImpl.class);
    @Autowired
    private PlanDerivativeService planDerivativeService;

    @Override
    public int getPlanLeftDay(Integer planId) {
        logger.info("get planId : [{}]",planId );
        return planDerivativeService.getLeftDay(planId);
    }
}
