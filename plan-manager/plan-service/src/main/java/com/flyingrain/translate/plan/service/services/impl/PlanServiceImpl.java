package com.flyingrain.translate.plan.service.services.impl;

import com.flyingrain.translate.plan.api.request.PlanRequest;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.service.services.PlanService;
import com.flyingrain.translate.plan.service.services.common.PlanStatus;
import com.flyingrain.translate.plan.service.services.dao.mapper.PlanMapper;
import com.flyingrain.translate.plan.service.services.dao.model.PlanModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wally on 4/25/17.
 */
@Component
public class PlanServiceImpl implements PlanService {

    private Logger logger = LoggerFactory.getLogger(PlanServiceImpl.class);
    @Autowired
    private PlanMapper planMapper;

    @Override
    public int makePlan(PlanRequest planRequest) {
        PlanModel planModel = new PlanModel();
        planModel.setBook_id(planRequest.getBookId());
        planModel.setBook_name(planRequest.getBookName());
        planModel.setDeadline(planRequest.getDeadline());
        planModel.setWord_number(planRequest.getNumber());
        planModel.setPlan_type(planRequest.getPlanType());
        planModel.setStatus(PlanStatus.UNDERWAY.status);
        logger.info("start to save plan [{}]", planModel);
        return planMapper.insertPlan(planModel);
    }


    @Override
    public List<Plan> queryPlan(Integer planId,int userId) {
        if(planId==null){
            return planMapper.getPlans(userId);
        }
        return null;
    }
}
