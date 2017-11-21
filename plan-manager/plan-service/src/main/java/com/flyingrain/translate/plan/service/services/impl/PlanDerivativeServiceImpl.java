package com.flyingrain.translate.plan.service.services.impl;

import com.flyingrain.translate.framework.lang.utils.DateUtil;
import com.flyingrain.translate.plan.api.response.PlanType;
import com.flyingrain.translate.plan.service.services.PlanDerivativeService;
import com.flyingrain.translate.plan.service.services.dao.mapper.PlanMapper;
import com.flyingrain.translate.plan.service.services.dao.mapper.UserWordRelationMapper;
import com.flyingrain.translate.plan.service.services.dao.model.PlanModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * 计划衍生服务
 * Created by wally on 11/21/17.
 */

@Component
public class PlanDerivativeServiceImpl implements PlanDerivativeService {

    private Logger logger = LoggerFactory.getLogger(PlanDerivativeServiceImpl.class);
    @Autowired
    private PlanMapper planMapper;

    @Autowired
    private UserWordRelationMapper userWordRelationMapper;

    /**
     * 获取最少剩余天数
     * @param planId
     * @return
     */
    @Override
    public int getLeftDay(int planId) {
        PlanModel planModel = planMapper.getPlan(planId);
        if (planModel.getPlan_type() == PlanType.BYNUMBER.getType()) {
            int recitedCount = userWordRelationMapper.getUserRecitedNumber(planModel.getUser_id(), planId);
            return (planModel.getAll_word_number() - recitedCount) / planModel.getWord_number();
        }else if(planModel.getPlan_type()==PlanType.BYDEADLINE.getType()){
            return (int) ChronoUnit.DAYS.between(DateUtil.dateToLocalDate(planModel.getDeadline()),DateUtil.dateToLocalDate(new Date()));
        }
        logger.error("planModel is error!",planModel);
        return 0;
    }
}
