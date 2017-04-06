package com.flyingrain.translate.words.collection.service.resourceImpl;

import com.flyingrain.translate.words.collection.api.WordsCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 4/6/17.
 */
@Component
public class WordsCollectionImpl implements WordsCollection {
    private Logger logger = LoggerFactory.getLogger(WordsCollectionImpl.class);

    public String collectWords() {
        logger.info("start to collect words!");
        return null;
    }
}
