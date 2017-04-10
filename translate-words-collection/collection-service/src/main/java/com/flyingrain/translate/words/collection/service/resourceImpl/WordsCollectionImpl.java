package com.flyingrain.translate.words.collection.service.resourceImpl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.words.collection.api.WordsCollection;
import com.flyingrain.translate.words.collection.service.collect.CollectWords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public WordsCollectionImpl(CollectWords collectWords) {
        this.collectWords = collectWords;
    }




    public String collectWords() {
        logger.info("start to collect words!");
        collectWords.collect("");
        return null;
    }
}
