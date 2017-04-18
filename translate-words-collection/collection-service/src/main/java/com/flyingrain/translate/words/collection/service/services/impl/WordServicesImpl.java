package com.flyingrain.translate.words.collection.service.services.impl;

import com.flyingrain.translate.words.collection.model.WordResult;
import com.flyingrain.translate.words.collection.service.collect.CollectWords;
import com.flyingrain.translate.words.collection.service.dao.mapper.WordMapper;
import com.flyingrain.translate.words.collection.service.dao.model.Word;
import com.flyingrain.translate.words.collection.service.services.WordServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wally on 4/18/17.
 */
@Component
public class WordServicesImpl implements WordServices{

    private Logger logger = LoggerFactory.getLogger(WordServicesImpl.class);

    @Autowired
    private WordMapper wordMapper;
    @Autowired
    private CollectWords collectWords;

    @Override
    public WordResult getWord(String word, int type) {
        Word myWord = wordMapper.getWord(word);
        //如果数据库中没有单词，则去渠道查询，然后再去数据库中查询
        if(myWord==null){
            logger.info("there is no word in database! to get it from channel![{}]",word);
            List<String> words = new ArrayList<>();
            words.add(word);
            collectWords.collect(words,type);
            myWord = wordMapper.getWord(word);
            //如果渠道收集不到则报错
            if(myWord==null){
                //CollectWords.errorWords.add(word);
                logger.error("no word to be found![{}]",word);
            }
        }



        return null;
    }
}
