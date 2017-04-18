package com.flyingrain.translate.words.collection.service.resourceImpl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.words.collection.api.WordsCollection;
import com.flyingrain.translate.words.collection.model.Result;
import com.flyingrain.translate.words.collection.service.collect.CollectSentences;
import com.flyingrain.translate.words.collection.service.collect.CollectWords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 4/6/17.
 */
@Component
@Resource
public class WordsCollectionImpl implements WordsCollection {
    private Logger logger = LoggerFactory.getLogger(WordsCollectionImpl.class);

    private CollectWords collectWords;
    @Autowired
    private Environment environment;
    @Autowired
    private CollectSentences collectSentences;

    @Autowired
    public WordsCollectionImpl(CollectWords collectWords) {
        this.collectWords = collectWords;
    }


    public Result<String> collectWords(String fileName, int type) {
        logger.info("start to collect words!");
        Result<String> result = new Result<>();
        if (fileName == null) {
            logger.error("fileName is null");
            result.setCode("99");
            result.setMsg("fileName is null!");
            return result;
        }
        collectWords.collect(environment.getProperty("file.path")+fileName, type);

        result.setCode("00");
        result.setMsg("collect success!");
        return result;
    }

    @Override
    public Result<String> collectSentence() {
        Result<String> result = new Result<>();
        collectSentences.collectSentences();
        result.setCode("00");
        result.setMsg("collect success!");
        return result;
    }
}
