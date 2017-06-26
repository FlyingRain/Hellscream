package com.flyingrain.translate.plan.service.services.impl;

import com.flyingrain.translate.plan.api.response.Sentence;
import com.flyingrain.translate.plan.api.response.Task;
import com.flyingrain.translate.plan.api.response.Word;
import com.flyingrain.translate.words.collection.result.WordResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 生成任务内容
 * Created by wally on 6/12/17.
 */
@Component
public class TaskCreator {

    private Logger logger = LoggerFactory.getLogger(TaskCreator.class);

    public Task getTask(List<WordResult> newWordResults, List<WordResult> oldWordReults) {
        if (CollectionUtils.isEmpty(newWordResults)) {
            newWordResults = new ArrayList<>();
        }
        if (CollectionUtils.isEmpty(oldWordReults)) {
            oldWordReults = new ArrayList<>();
        }
        Task task = new Task();
        task.setNewWordNumber(newWordResults.size());
        task.setWordNumber(newWordResults.size() + oldWordReults.size());
        task.setNewWords(transfer(newWordResults));
        task.setOldWords(transfer(oldWordReults));
        logger.info("get task! :[{}]", task);
        return task;
    }


    private List<Word> transfer(List<WordResult> results) {
        if (CollectionUtils.isEmpty(results)) {
            return new ArrayList<>();
        }
        return results.stream().map(this::transferSingle).collect(Collectors.toList());
    }


    private Word transferSingle(WordResult result) {
        Word word = new Word();
        BeanUtils.copyProperties(result, word);
        if (result.getSamples() != null) {
            Sentence sentence = new Sentence();
            BeanUtils.copyProperties(result.getSamples(), sentence);
            word.setSamples(sentence);
        }
        return word;
    }
}
