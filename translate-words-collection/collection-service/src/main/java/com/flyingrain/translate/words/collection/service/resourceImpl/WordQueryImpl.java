package com.flyingrain.translate.words.collection.service.resourceImpl;

import com.flyingrain.translate.words.collection.api.WordQuery;
import com.flyingrain.translate.words.collection.model.Result;
import com.flyingrain.translate.words.collection.model.SampleSentence;
import com.flyingrain.translate.words.collection.model.WordResult;
import com.flyingrain.translate.words.collection.service.services.WordServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wally on 4/18/17.
 */
public class WordQueryImpl implements WordQuery {

    private Logger logger = LoggerFactory.getLogger(WordQueryImpl.class);

    @Autowired
    private WordServices wordServices;

    @Override
    public Result<WordResult> queryWord(String word, int type) {
        logger.info("start to query [{}] , type is [{}]",word,type);
        WordResult wordResult = wordServices.getWord(word,type);
        return null;
    }

    @Override
    public Result<SampleSentence> querySentence(String wordId) {
        return null;
    }
}
