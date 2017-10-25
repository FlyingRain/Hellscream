package com.flyingrain.translate.plan.service.services.impl.tasks;

import com.flyingrain.translate.plan.api.response.Task;
import com.flyingrain.translate.plan.service.services.common.WordProficiency;
import com.flyingrain.translate.plan.service.services.dao.mapper.UserWordRelationMapper;
import com.flyingrain.translate.plan.service.services.dao.model.PlanModel;
import com.flyingrain.translate.plan.service.services.dao.model.UserWordRelation;
import com.flyingrain.translate.plan.service.services.impl.DayWordNumberCalculator;
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
 * 基于固定日期生成每日计划
 * Created by wally on 10/23/17.
 */
@Component("dateBased")
public class DateBasedTaskGenerator implements TaskGenerator {

    private Logger logger = LoggerFactory.getLogger(DateBasedTaskGenerator.class);

    @Autowired
    private DayWordNumberCalculator calculator;


    @Autowired
    private UserWordRelationMapper userWordRelationMapper;

    @Autowired
    private WordQuery wordQuery;

    @Autowired
    private BookQuery bookQuery;

    @Autowired
    private TaskCreator creator;


    @Override
    public Task generateTask(int userId, PlanModel planModel, Date planDate) {
        List<WordResult> newWords = getNewWords(planModel);
        List<WordResult> oldWords = getOldWords(planModel);
        return creator.getTask(newWords, oldWords);
    }

    private List<WordResult> getOldWords(PlanModel planModel) {
        List<UserWordRelation> relations = userWordRelationMapper.getWordsByProficiency(planModel.getUser_id(), planModel.getId(), WordProficiency.FAMILIAR.getProficiency());
        List<WordResult> results = new ArrayList<>();
        if (CollectionUtils.isEmpty(relations)) {
            return results;
        }
        return relations.stream().map(relation -> wordQuery.querySingleWord(relation.getWord_id())).collect(Collectors.toList());
    }

    private List<WordResult> getNewWords(PlanModel planModel) {
        int wordNumber = calculator.calculateDayWordNumber(planModel);
        List<UserWordRelation> userPlanWords = userWordRelationMapper.getUserPlanWords(planModel.getUser_id(), planModel.getId());
        BookWords bookWords = new BookWords();
        bookWords.setBookType(planModel.getBook_id());
        bookWords.setNumber(wordNumber);
        bookWords.setWordIds(userPlanWords.stream().map(UserWordRelation::getWord_id).collect(Collectors.toList()));
        logger.info("start to get new Word! bookWords:[{}]", bookWords);
        return bookQuery.getBookWords(bookWords);
    }


}
