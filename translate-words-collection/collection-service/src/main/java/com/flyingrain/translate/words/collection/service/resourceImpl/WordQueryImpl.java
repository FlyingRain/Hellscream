package com.flyingrain.translate.words.collection.service.resourceImpl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.words.collection.api.WordQuery;
import com.flyingrain.translate.words.collection.result.Result;
import com.flyingrain.translate.words.collection.result.ResultType;
import com.flyingrain.translate.words.collection.result.SentenceDefine;
import com.flyingrain.translate.words.collection.result.WordResult;
import com.flyingrain.translate.words.collection.service.services.WordServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 4/18/17.
 */
@Component
@Resource
public class WordQueryImpl implements WordQuery {

    private Logger logger = LoggerFactory.getLogger(WordQueryImpl.class);

    @Autowired
    private WordServices wordServices;

    @Override
    public WordResult queryWord(String word, int type) {
        logger.info("start to query [{}] , type is [{}]",word,type);
        return wordServices.getWord(word,type);
    }

    @Override
    public SentenceDefine querySentence(int wordId) {
        logger.info("start to query sentence for word [{}]",wordId);
        return wordServices.getSentence(wordId);
    }

    @Override
    public WordResult querySingleWord(int wordId) {
        return wordServices.getWordById(wordId);
    }
}
