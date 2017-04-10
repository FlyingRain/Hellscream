package com.flyingrain.translate.words.collection.service.collect.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flyingrain.translate.words.collection.service.collect.CollectWords;
import com.flyingrain.translate.words.collection.service.collect.impl.worddefine.QueryResult;
import com.flyingrain.translate.words.collection.service.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.Query;
import java.io.IOException;
import java.util.List;

/**
 * Created by wally on 4/10/17.
 */
@Component
public class CollectWordsImpl implements CollectWords {

    private Logger logger = LoggerFactory.getLogger(CollectWordsImpl.class);
    @Autowired
    private AudioSaver audioSaver;

    public void collect(String path) {
        String result = HttpUtil.sendGet("https://api.shanbay.com/bdc/search/?word=good");
        audioSaver.saveAudiobyUrl("http://media-audio1.qiniu.baydn.com/uk/v/vo/vocabulary_v3.mp3");
        QueryResult queryResult = paraseResult(result);

    }

    public void collect(List<String> words) {

    }

    private QueryResult paraseResult(String result) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        try {
            logger.info("start parse result!");
            return objectMapper.readValue(result, QueryResult.class);
        } catch (IOException e) {
            logger.error("parse result error!result is [{}]", result, e);
        }
        return null;
    }


}
