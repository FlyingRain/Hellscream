package com.flyingrain.translate.plan.service.services.impl;

import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.Word;
import com.flyingrain.translate.plan.service.services.PlanService;
import com.flyingrain.translate.plan.service.services.TaskGenerator;
import com.flyingrain.translate.plan.service.services.common.TaskStatus;
import com.flyingrain.translate.plan.service.services.common.WordProficiency;
import com.flyingrain.translate.plan.service.services.dao.mapper.DayPlanMapper;
import com.flyingrain.translate.plan.service.services.dao.mapper.UserWordRelationMapper;
import com.flyingrain.translate.plan.service.services.dao.model.DayPlan;
import com.flyingrain.translate.plan.service.services.dao.model.UserWordRelation;
import com.flyingrain.translate.plan.service.services.utils.DateUtil;
import com.flyingrain.translate.plan.service.services.utils.FileUtil;
import com.flyingrain.translate.words.collection.api.BookQuery;
import com.flyingrain.translate.words.collection.api.WordQuery;
import com.flyingrain.translate.words.collection.request.BookWords;
import com.flyingrain.translate.words.collection.result.WordResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wally on 5/10/17.
 */
@Component
public class TaskGeneratorImpl implements TaskGenerator {

    private Logger logger = LoggerFactory.getLogger(TaskGeneratorImpl.class);

    @Autowired
    private DayPlanMapper dayPlanMapper;
    @Autowired
    private UserWordRelationMapper userWordRelationMapper;
    @Autowired
    private BookQuery bookQuery;
    @Autowired
    private PlanService planService;
    @Autowired
    private WordQuery wordQuery;
    @Autowired
    private TaskStringGenerator taskStringGenerator;


    @Override
    public String generateTasks() {
        Date startDate = DateUtil.getTodayZeroDay();
        Date endDate = DateUtil.addDay(startDate, 1);
        List<DayPlan> dayPlans = dayPlanMapper.getLatestDayPlans(TaskStatus.COMPLETE.value, startDate, endDate);
        logger.info("start generate [{}] tasks!", dayPlans.size());
        dayPlans.forEach(this::generateTasks);
        return "generate success!";
    }

    /**
     * 生成新任务
     *
     * @param dayPlan
     * @return
     */
    private String generateTasks(DayPlan dayPlan) {
        if (dayPlan == null) {
            logger.error("dayPlan is null!");
            return null;
        }
        List<WordResult> newWords = getNewWords(dayPlan);
        List<WordResult> oldWords = getOldWords(dayPlan);
        String result = taskStringGenerator.generator(newWords, oldWords);
        String filePath = getFilePath(dayPlan);
        logger.info("start to save file: [{}]", filePath);
        FileUtil.saveFile(filePath, result);
        return result;
    }

    /**
     * 获取要背的新单词
     *
     * @param dayPlan
     * @return
     */
    private List<WordResult> getNewWords(DayPlan dayPlan) {
        List<Plan> plans = planService.queryPlan(dayPlan.getPlan_id(), 0);
        if (CollectionUtils.isEmpty(plans)) {
            logger.error("there is no plan in database![{}]", dayPlan);
            return null;
        }
        if (plans.size() != 1) {
            logger.error("more than one plan in database!", dayPlan);
            return null;
        }

        Plan plan = plans.get(0);
        String wordIdString = dayPlan.getWord_ids();
        String wordIds[] = wordIdString.split(",");
        List<String> wordIdList = Arrays.asList(wordIds);

        BookWords bookWords = new BookWords();
        bookWords.setWordIds(transferToInteger(wordIdList));
        bookWords.setBookType(plan.getBookId());
        bookWords.setNumber(plan.getNumber());

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


    private List<Integer> transferToInteger(List<String> wordIds) {
        List<Integer> realWordIds = new ArrayList<>();
        if (CollectionUtils.isEmpty(wordIds)) {
            return realWordIds;
        }
        realWordIds = wordIds.stream().filter(wordId -> (!"".equals(wordId) && wordId != null)).map(Integer::parseInt).collect(Collectors.toList());
        return realWordIds;
    }

    @Override
    public String generateTask(int userId, int planId) {
        DayPlan dayPlan = dayPlanMapper.getDayPlanById(userId, planId);
        return generateTasks(dayPlan);
    }


    private String getFilePath(DayPlan dayPlan) {
        String userHome = System.getProperty("user.home");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date taskDate = DateUtil.addDay(DateUtil.getTodayZeroDay(), 1);
        Path path = Paths.get(userHome, "plan", "task", format.format(taskDate), dayPlan.getUser_id() + ".txt");
        return path.toAbsolutePath().toString();

    }

}
