package com.flyingrain.translate.plan.service.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.plan.api.intf.TaskResource;
import com.flyingrain.translate.plan.api.request.TaskResult;
import com.flyingrain.translate.plan.api.request.WordReciteResult;
import com.flyingrain.translate.plan.api.response.Task;
import com.flyingrain.translate.plan.service.common.PlanExceptionCode;
import com.flyingrain.translate.plan.service.services.TaskGenerator;
import com.flyingrain.translate.plan.service.services.common.PlanStatus;
import com.flyingrain.translate.plan.service.services.common.WordProficiency;
import com.flyingrain.translate.plan.service.services.dao.mapper.DayPlanMapper;
import com.flyingrain.translate.plan.service.services.dao.mapper.PlanMapper;
import com.flyingrain.translate.plan.service.services.dao.mapper.UserWordRelationMapper;
import com.flyingrain.translate.plan.service.services.dao.model.PlanModel;
import com.flyingrain.translate.plan.service.services.dao.model.UserWordRelation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 每日任务
 * Created by wally on 5/4/17.
 */
@Resource
@Component
public class TaskResourceImpl implements TaskResource {
    private Logger logger = LoggerFactory.getLogger(TaskResourceImpl.class);
    @Autowired
    private TaskGenerator taskGenerator;
    @Autowired
    private DayPlanMapper dayPlanMapper;
    @Autowired
    private PlanMapper planMapper;
    @Autowired
    private UserWordRelationMapper relationMapper;

    @Override
    public Task getUserPlanTask(Integer planId, Integer userId, Date planDate) {
        return taskGenerator.generateTask(userId, planId, planDate);
    }

    @Override

    public String synchronizeTaskResult(TaskResult taskResult) {
        //更新结果
        updateTask(taskResult);
        //更新计划表
        updatePlan(taskResult);
        return null;
    }


    /**
     * 更新计划状态和单词熟练度
     *
     * @param taskResult
     */
    @Transactional
    private void updateTask(TaskResult taskResult) {
        int updateNumber = dayPlanMapper.updateTaskStatus(taskResult.getStatus(), taskResult.getTaskId());
        if (updateNumber != 1) {
            logger.error("update plan error! number is [{}]",updateNumber);
            throw new FlyException(PlanExceptionCode.SYNCHRONIZE_PLAN_FAIL.getCode(), PlanExceptionCode.SYNCHRONIZE_PLAN_FAIL.getMsg());
        }
        int userId = taskResult.getUserId();
        int taskId = taskResult.getTaskId();
        //获取熟练度为非陌生的单词
        List<UserWordRelation> relations = taskResult.getWordReciteResults().stream().filter(wordReciteResult -> wordReciteResult.getProficiency() != WordProficiency.STRANGE.getProficiency()).map(wordReciteResult -> transferReciteResult(wordReciteResult, userId, taskId)).collect(Collectors.toList());
        //更新单词
        relationMapper.batchInsertOnDuplicate(relations);
    }

    private UserWordRelation transferReciteResult(WordReciteResult reciteResult, int userId, int taskId) {
        UserWordRelation relation = new UserWordRelation();
        relation.setPlan_id(taskId);
        relation.setUser_id(userId);
        relation.setWord_id(reciteResult.getWordId());
        relation.setProficiency(reciteResult.getProficiency());
        return relation;
    }

    /**
     * 更新计划表
     *
     * @param result
     */
    private void updatePlan(TaskResult result) {
        //获取已经掌握的单词的个数
        int number = result.getWordReciteResults().stream().filter(wordReciteResult -> wordReciteResult.getProficiency() == WordProficiency.MASTER.getProficiency()).collect(Collectors.toList()).size();
        PlanModel model = planMapper.getPlanByTaskId(result.getTaskId());
        int completeNumber = model.getComplete_number();
        if ((completeNumber + number) == model.getAll_word_number()) {
            logger.info("plan complete !start to over it![{}]",model);
            planMapper.updatePlanStatus(PlanStatus.SUCCESS.status,model.getId());
        }
        else if((completeNumber + number)>model.getAll_word_number()){
            logger.error("plan number is error! to update number is [{}],but max is [{}]",new Object[]{(completeNumber + number),model.getAll_word_number()});

        }

    }
}
