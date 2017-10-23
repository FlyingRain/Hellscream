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
import com.flyingrain.translate.words.collection.api.BookQuery;
import com.flyingrain.translate.words.collection.result.Book;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private BookQuery bookQuery;

    @Override
    @Transactional
    public Integer makePlan(PlanRequest planRequest) {
        PlanModel planModel = new PlanModel();
        Book book = bookQuery.getBook(planRequest.getBookId());
        planModel.setAll_word_number(book.getWordNumber());
        planModel.setBook_id(planRequest.getBookId());
        if (planRequest.getDeadline() != null) {
            try {
                planModel.setDeadline(DateUtils.parseDate(planRequest.getDeadline(), "yyyy/MM/dd"));
            } catch (ParseException e) {
                throw new FlyException(PlanExceptionCode.PARAM_INVALID.getCode(), "deadline format error!");
            }
        }
        planModel.setWord_number(planRequest.getNumber());
        planModel.setUser_id(planRequest.getUserId());
        planModel.setPlan_type(planRequest.getPlanType());
        planModel.setStatus(PlanStatus.UNDERWAY.status);
        logger.info("start to save plan [{}]", planModel);
        int planId;
        try {
            planMapper.insertPlan(planModel);
            planId = planModel.getId();
        } catch (Exception e) {
            logger.error("insert plan error!", e);
            throw new FlyException(PlanExceptionCode.MAKE_PLAN_FAILURE.getCode(), PlanExceptionCode.MAKE_PLAN_FAILURE.getMsg());
        }
        List<PlanModel> plans = planMapper.getUserPlanByStatus(planRequest.getUserId(), PlanStatus.UNDERWAY.status);
        if (CollectionUtils.isEmpty(plans) || plans.size() > 1) {
            throw new FlyException(PlanExceptionCode.MAKE_PLAN_DUPLICATE.getCode(), PlanExceptionCode.MAKE_PLAN_DUPLICATE.getMsg());
        }
        return planId;
    }


    @Override
    public List<Plan> queryPlan(Integer planId, int userId) {
        if (planId == null) {
            if (CollectionUtils.isEmpty(planMapper.getPlans(userId))) {
                throw new FlyException(PlanExceptionCode.PLAN_NOT_EXIT.getCode(), PlanExceptionCode.PLAN_NOT_EXIT.getMsg());
            }
            return planMapper.getPlans(userId).stream().map(this::transferPlanModel).collect(Collectors.toList());
        } else {
            if (planMapper.getPlan(planId) == null) {
                throw new FlyException(PlanExceptionCode.PLAN_NOT_EXIT.getCode(), PlanExceptionCode.PLAN_NOT_EXIT.getMsg());
            }
            Plan plan = transferPlanModel(planMapper.getPlan(planId));
            List<Plan> plans = new ArrayList<>();
            plans.add(plan);
            return plans;
        }
    }

    @Override
    public List<Plan> querySpecificPlan(int userId, int status) {
        List<PlanModel> plans = planMapper.getUserPlanByStatus(userId, status);
        return plans.stream().map(this::transferPlanModel).collect(Collectors.toList());
    }

    /**
     * 修改计划
     *
     * @param planRequest
     * @return
     */
    @Override
    @Transactional
    public int modifyPlan(PlanRequest planRequest) {
        PlanModel planModel = new PlanModel();
        PlanModel oldPlan = planMapper.getPlan(planRequest.getId());
        boolean changeBook = (planModel.getBook_id() == oldPlan.getBook_id());
        planModel.setId(planRequest.getId());
        planModel.setBook_id(planRequest.getBookId());
        Book book = bookQuery.getBook(planRequest.getBookId());
        planModel.setAll_word_number(changeBook ? book.getWordNumber() : oldPlan.getAll_word_number());
        planModel.setComplete_number(changeBook ? 0 : oldPlan.getComplete_number());
        try {
            planModel.setDeadline(DateUtils.parseDate(planRequest.getDeadline(), "yyyy/MM/dd"));
        } catch (ParseException e) {
            throw new FlyException(PlanExceptionCode.PARAM_INVALID.getCode(), "deadline format error!");
        }
        planModel.setWord_number(planRequest.getNumber());
        planModel.setPlan_type(planRequest.getPlanType());
        planModel.setStatus(PlanStatus.UNDERWAY.status);
        logger.info("start to update plan [{}]", planModel);
        int updateNumber = planMapper.updatePlan(planModel);
        if (updateNumber != 1) {
            throw new FlyException(PlanExceptionCode.MODIFY_PLAN_FAILURE.getCode());
        }
        if (changeBook)
            relationMapper.deletePlanProficiency(planRequest.getId());
        return updateNumber;
    }

    @Override
    public Plan getUserPlan(int userId, int planId) {
        return transferPlanModel(planMapper.getUserPlan(planId, userId));
    }


    private Plan transferPlanModel(PlanModel model) {
        if (model == null) {
            return null;
        }
        Plan plan = new Plan();
        plan.setId(model.getId());
        plan.setBookId(model.getBook_id());
        plan.setCompleteNumber(model.getComplete_number());
        plan.setDeadline(model.getDeadline());
        plan.setEndDate(model.getEnd_date());
        plan.setNumber(model.getWord_number());
        plan.setUserId(model.getUser_id());
        plan.setAllNumber(model.getAll_word_number());
        plan.setPlanStatus(model.getStatus());
        plan.setPlanType(model.getPlan_type());
        return plan;
    }
}
