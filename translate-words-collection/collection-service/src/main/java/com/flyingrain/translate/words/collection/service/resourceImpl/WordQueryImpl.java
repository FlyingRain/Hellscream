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
    public Result<WordResult> queryWord(String word, int type) {
        logger.info("start to query [{}] , type is [{}]",word,type);
        Result<WordResult> resut = new Result<>();
        WordResult wordResult = wordServices.getWord(word,type);
        resut.setMsg(ResultType.SUCCESS.desc);
        resut.setCode(ResultType.FAIL.code);
        if(wordResult==null){
            resut.setMsg("can't query this word!");
            resut.setCode(ResultType.FAIL.code);
        }
        resut.setRealResult(wordResult);
        return resut;
    }

    @Override
    public Result<SentenceDefine> querySentence(int wordId) {
        logger.info("start to query sentence for word [{}]",wordId);
        SentenceDefine sentenceDefine = wordServices.getSentence(wordId);
        Result<SentenceDefine> result = new Result<>();
        result.setCode(ResultType.SUCCESS.code);
        result.setMsg(ResultType.SUCCESS.desc);
        result.setRealResult(sentenceDefine);
        return result;
    }

    @Override
    public WordResult querySingleWord(int wordId) {
        return wordServices.getWordById(wordId);
    }
}
