package com.flyingrain.translate.plan.service.services.impl.tasks;

import com.flyingrain.translate.plan.api.response.Task;
import com.flyingrain.translate.plan.service.services.TaskCache;
import com.flyingrain.translate.plan.service.services.common.TaskStatus;
import com.flyingrain.translate.plan.service.services.common.WordProficiency;
import com.flyingrain.translate.plan.service.services.dao.mapper.DayPlanMapper;
import com.flyingrain.translate.plan.service.services.dao.mapper.UserWordRelationMapper;
import com.flyingrain.translate.plan.service.services.dao.model.DayPlan;
import com.flyingrain.translate.plan.service.services.dao.model.PlanModel;
import com.flyingrain.translate.plan.service.services.dao.model.UserWordRelation;
import com.flyingrain.translate.plan.service.services.impl.TaskCreator;
import com.flyingrain.translate.words.collection.api.BookQuery;
import com.flyingrain.translate.words.collection.api.WordQuery;
import com.flyingrain.translate.words.collection.request.BookWords;
import com.flyingrain.translate.words.collection.result.WordResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 基于固定单词数生成计划
 * Created by wally on 10/23/17.
 */
@Component("numberBased")
public class NumberBasedTaskGenerator implements TaskGenerator {

    private Logger logger = LoggerFactory.getLogger(NumberBasedTaskGenerator.class);

    @Autowired
    private DayPlanMapper dayPlanMapper;
    @Autowired
    private TaskCache taskCache;
    @Autowired
    private TaskCreator taskCreator;
    @Autowired
    private BookQuery bookQuery;
    @Autowired
    private UserWordRelationMapper userWordRelationMapper;
    @Autowired
    private WordQuery wordQuery;


    @Override
    public Task generateTask(int userId, PlanModel planModel, Date planDate) {
        DayPlan latestDayPlan = dayPlanMapper.getUserLatestTask(userId, planModel.getId());
        //如果是第一次生成计划则构造dayPlan
        if (latestDayPlan == null) {
            latestDayPlan = new DayPlan();
            latestDayPlan.setPlan_id(planModel.getId());
            latestDayPlan.setUser_id(userId);
            latestDayPlan.setStatus(TaskStatus.COMPLETE.value);
        }

        //如果最近一次计划未完成则返回已有计划,更新计划日期
        if (latestDayPlan.getStatus() == TaskStatus.PROCESSING.value) {
            return taskCache.getTask(latestDayPlan);
        } else {
            //如果完成则生成新的计划并返回
            return generateTasksByDayPlan(latestDayPlan, planDate, planModel);
        }

    }


    /**
     * 生成新任务
     *
     * @param dayPlan
     * @return
     */
    private Task generateTasksByDayPlan(DayPlan dayPlan, Date planDate, PlanModel planModel) {
        if (dayPlan == null) {
            logger.error("dayPlan is null!");
            return null;
        }
        List<WordResult> newWords = getNewWords(dayPlan, planModel);
        List<WordResult> oldWords = getOldWords(dayPlan);
        //获取计划内容
        return taskCreator.getTask(newWords, oldWords);
    }


    /**
     * 获取要背的新单词
     *
     * @param dayPlan
     * @return
     */
    private List<WordResult> getNewWords(DayPlan dayPlan, PlanModel planModel) {
        List<UserWordRelation> reciteWords = userWordRelationMapper.getUserPlanWords(dayPlan.getUser_id(), dayPlan.getPlan_id());
        List<Integer> wordIdList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(reciteWords)) {
            wordIdList = reciteWords.stream().map(UserWordRelation::getWord_id).collect(Collectors.toList());
        }
        BookWords bookWords = new BookWords();
        bookWords.setWordIds(wordIdList);
        bookWords.setBookType(planModel.getBook_id());
        bookWords.setNumber(planModel.getWord_number());
        return bookQuery.getBookWords(bookWords);
    }

    /**
     * 获取上一次未背熟的单词
     *
     * @param dayPlan
     * @return
     */
    private List<WordResult> getOldWords(DayPlan dayPlan) {
        List<UserWordRelation> relations = userWordRelationMapper.getWordsByProficiency(dayPlan.getUser_id(), dayPlan.getPlan_id(), WordProficiency.FAMILIAR.getProficiency());
        List<WordResult> results = new ArrayList<>();
        if (CollectionUtils.isEmpty(relations)) {
            return results;
        }
        return relations.stream().map(relation -> wordQuery.querySingleWord(relation.getWord_id())).collect(Collectors.toList());
    }

}
