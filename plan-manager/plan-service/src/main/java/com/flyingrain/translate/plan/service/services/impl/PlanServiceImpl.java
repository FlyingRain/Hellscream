package com.flyingrain.translate.plan.service.services.impl;

import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.plan.api.request.PlanRequest;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.service.common.PlanExceptionCode;
import com.flyingrain.translate.plan.service.services.PlanService;
import com.flyingrain.translate.plan.service.services.common.PlanStatus;
import com.flyingrain.translate.plan.service.services.dao.mapper.PlanMapper;
import com.flyingrain.translate.plan.service.services.dao.mapper.UserWordRelationMapper;
import com.flyingrain.translate.plan.service.services.dao.model.PlanModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wally on 4/25/17.
 */
@Component
public class PlanServiceImpl implements PlanService {

    private Logger logger = LoggerFactory.getLogger(PlanServiceImpl.class);
    @Autowired
    private PlanMapper planMapper;

    @Autowired
    private UserWordRelationMapper relationMapper;

    @Override
    @Transactional
    public Integer makePlan(PlanRequest planRequest) {
        PlanModel planModel = new PlanModel();
        planModel.setBook_id(planRequest.getBookId());
        planModel.setDeadline(planRequest.getDeadline());
        planModel.setWord_number(planRequest.getNumber());
        planModel.setPlan_type(planRequest.getPlanType());
        planModel.setStatus(PlanStatus.UNDERWAY.status);
        logger.info("start to save plan [{}]", planModel);
        int planId = planMapper.insertPlan(planModel);
        List<Plan> plans = planMapper.getUserPlanByStatus(planRequest.getUserId(),PlanStatus.UNDERWAY.status);
        if(CollectionUtils.isEmpty(plans)||plans.size()>1){
            throw new FlyException(PlanExceptionCode.MAKE_PLAN_DUPLICAT.getCode(),PlanExceptionCode.MAKE_PLAN_DUPLICAT.getMsg());
        }
        return planId;
    }


    @Override
    public List<Plan> queryPlan(Integer planId, int userId) {
        if (planId == null) {
            return planMapper.getPlans(userId);
        } else {
            Plan plan = planMapper.getPlan(planId);
            List<Plan> plans = new ArrayList<>();
            plans.add(plan);
            return plans;
        }
    }

    @Override
    public List<Plan> querySpecificPlan(int userId, int status) {
        return null;
    }

    /**
     * 修改计划
     * @param planRequest
     * @return
     */
    @Override
    @Transactional
    public int modifyPlan(PlanRequest planRequest) {
        PlanModel planModel = new PlanModel();
        planModel.setId(planRequest.getId());
        planModel.setBook_id(planRequest.getBookId());
        planModel.setDeadline(planRequest.getDeadline());
        planModel.setWord_number(planRequest.getNumber());
        planModel.setPlan_type(planRequest.getPlanType());
        planModel.setStatus(PlanStatus.UNDERWAY.status);
        logger.info("start to update plan [{}]", planModel);
        int updateNumber = planMapper.updatePlan(planModel);
        if(updateNumber!=1){
            throw new FlyException(PlanExceptionCode.MODIFY_PLAN_FALURE.getCode());
        }
        relationMapper.deletePlanProficiency(planRequest.getId());
        return updateNumber;
    }
}
