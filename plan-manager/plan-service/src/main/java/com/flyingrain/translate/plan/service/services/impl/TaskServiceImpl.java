package com.flyingrain.translate.plan.service.services.impl;

import com.flyingrain.translate.dungeon.api.DungeonResources;
import com.flyingrain.translate.dungeon.api.responses.DungeonPlanResult;
import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.framework.lang.utils.DateUtil;
import com.flyingrain.translate.plan.api.response.*;
import com.flyingrain.translate.plan.service.common.PlanExceptionCode;
import com.flyingrain.translate.plan.service.services.TaskCache;
import com.flyingrain.translate.plan.service.services.TaskService;
import com.flyingrain.translate.plan.service.services.common.TaskStatus;
import com.flyingrain.translate.plan.service.services.dao.mapper.DayPlanMapper;
import com.flyingrain.translate.plan.service.services.dao.mapper.PlanMapper;
import com.flyingrain.translate.plan.service.services.dao.model.DayPlan;
import com.flyingrain.translate.plan.service.services.dao.model.PlanModel;
import com.flyingrain.translate.plan.service.services.impl.tasks.TaskGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wally on 5/10/17.
 */
@Component
public class TaskServiceImpl implements TaskService {

    private Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private DayPlanMapper dayPlanMapper;

    @Autowired
    private TaskCache taskCache;

    @Autowired
    private PlanMapper planMapper;

    @Autowired
    private DungeonResources dungeonResources;

    @Autowired
    private Map<String, TaskGenerator> taskGeneratorMap;


    @Override
    public String generateTasks() {
        Date startDate = DateUtil.getTodayZeroDay();
        Date endDate = DateUtil.addDay(startDate, 1);

        return "generate success!";
    }


    private List<Integer> transferToInteger(List<String> wordIds) {
        List<Integer> realWordIds = new ArrayList<>();
        if (CollectionUtils.isEmpty(wordIds)) {
            return realWordIds;
        }
        realWordIds = wordIds.stream().filter(wordId -> (!"".equals(wordId) && wordId != null)).map(Integer::parseInt).collect(Collectors.toList());
        return realWordIds;
    }

    /**
     * 获取个人当日的计划
     *
     * @param userId
     * @param planId
     * @param planDate
     * @return
     */
    @Override
    public Task generateTask(int userId, int planId, Date planDate) {
        logger.info("start to generate dayPlan: userId:[{}],planId:[{}],planDate:[{}]", new Object[]{userId, planId, planDate.toString()});
        Date planStartDate = DateUtil.getDateZeroDay(planDate);
        Date planEndDate = DateUtil.addDay(planStartDate, 1);
        DayPlan dayPlan = dayPlanMapper.getDayPlan(userId, planStartDate, planEndDate);
        if (dayPlan == null) {
            PlanModel planModel = planMapper.getPlan(planId);
            TaskGenerator generator = taskGeneratorMap.get(getPanType(planModel.getPlan_type()));
            if (generator == null) {
                throw new FlyException(PlanExceptionCode.PLANTYPE_ERROR.getCode(), PlanExceptionCode.PLANTYPE_ERROR.getMsg());
            }
            Task task = generator.generateTask(userId, planModel, planDate);
            List<Integer> wordIds = Stream.of(task.getNewWords(), task.getOldWords()).flatMap(List::stream).map(Word::getWordId).collect(Collectors.toList());
            DayPlan newDayPlan = getNewDayPlan(planModel, wordIds, planDate);
            try {
                dayPlanMapper.insertDayPlan(newDayPlan);
            } catch (Exception e) {
                logger.error("insert into recitePlan failed!", e);
                throw new FlyException(PlanExceptionCode.PLAN_GEN_FAILED.getCode(), PlanExceptionCode.PLAN_GEN_FAILED.getMsg());
            }
            task.setId(newDayPlan.getId());
            DungeonPlanResult dungeonPlanResult = dungeonResources.getDungeonPlan(newDayPlan.getUser_id(), newDayPlan.getPlan_id());
            task.setDungeonInfo(transferDungeonResult(dungeonPlanResult));
            //缓存生成的Task
            taskCache.cacheTask(task, newDayPlan);
            return task;
        } else {
            logger.info("dayplan has existed! get dayPlan from cache :[{}]", dayPlan);
            Task task = taskCache.getTask(dayPlan);
            if (task != null) {
                return task;
            }
        }
        return null;
    }

    @Override
    public TaskSummary getTaskSummary(int userId, int planId, Date planDate) {
        TaskSummary summary = taskCache.getTaskSummary(planDate, userId);
        if (summary == null) {
            generateTask(userId, planId, planDate);
        }
        return taskCache.getTaskSummary(planDate, userId);
    }


    private String getPanType(int planType) {
        if (planType == PlanType.BYDEADLINE.getType()) {
            return PlanType.BYDEADLINE.getDesc();
        } else if (planType == PlanType.BYNUMBER.getType()) {
            return PlanType.BYNUMBER.getDesc();
        }
        return null;
    }


    private DayPlan getNewDayPlan(PlanModel planModel, List<Integer> wordIds, Date planDate) {
        Date startDate = (planDate == null ? DateUtil.addDay(DateUtil.getTodayZeroDay(), 1) : planDate);
        DayPlan newDayPlan = new DayPlan();
        newDayPlan.setStatus(TaskStatus.PROCESSING.value);
        newDayPlan.setPlan_date(startDate);
        wordIds.stream().map(Object::toString).reduce((a, b) -> a + "," + b).ifPresent(newDayPlan::setWord_ids);
        newDayPlan.setPlan_id(planModel.getId());
        newDayPlan.setUser_id(planModel.getUser_id());
        newDayPlan.setStatus(TaskStatus.PROCESSING.value);
        return newDayPlan;
    }

    private DungeonInfo transferDungeonResult(DungeonPlanResult dungeonPlanResult) {
        DungeonInfo dungeonInfo = new DungeonInfo();
        dungeonInfo.setDungeonInstanceId(dungeonPlanResult.getDungeonInstanceId());
        dungeonInfo.setStatus(dungeonPlanResult.getStatus());
        dungeonInfo.setDesc(dungeonPlanResult.getDesc());
        return dungeonInfo;
    }

}
