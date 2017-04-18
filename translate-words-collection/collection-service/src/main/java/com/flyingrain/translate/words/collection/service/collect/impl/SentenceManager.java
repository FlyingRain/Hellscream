package com.flyingrain.translate.words.collection.service.collect.impl;

import com.flyingrain.translate.words.collection.service.collect.impl.words.SentenceDefine;
import com.flyingrain.translate.words.collection.service.dao.mapper.WordMapper;
import com.flyingrain.translate.words.collection.service.dao.mapper.WordSentenceMapper;
import com.flyingrain.translate.words.collection.service.dao.model.Word;
import com.flyingrain.translate.words.collection.service.dao.model.WordSentence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wally on 4/17/17.
 */
@Component
public class SentenceManager {

    private Logger logger = LoggerFactory.getLogger(SentenceManager.class);


    @Autowired
    private WordSentenceMapper wordSentenceMapper;

    @Autowired
    private WordMapper wordMapper;


    public int saveSentence(SentenceDefine sentenceDefine){
        List<WordSentence> wordSentences = new ArrayList<>();
        List<SentenceDefine.Mysentence> mysentences = sentenceDefine.getMysentences();
        Word word = wordMapper.getWord(sentenceDefine.getWord());
        mysentences.forEach(mysentence -> {
            WordSentence wordSentence = new WordSentence();
            wordSentence.setFirst(mysentence.getFirst());
            wordSentence.setLast(mysentence.getLast());
            wordSentence.setSentence(mysentence.getFirst()+" "+sentenceDefine.getWord()+" "+mysentence.getLast());
            wordSentence.setTransaction(mysentence.getTranslation());
            wordSentence.setLike(mysentence.getLike());
            wordSentence.setUnlike(mysentence.getUnlike());
            wordSentence.setWord_id(word.getId());
            wordSentence.setWord(sentenceDefine.getWord());
            wordSentences.add(wordSentence);
        });


        logger.info("start to update words!" + sentenceDefine.getWord());
        int i = wordMapper.updateWordSentenceStatus(1,sentenceDefine.getWord());
        if(i!=1){
            logger.error("update word error! update size is [{}]",i);
            return 0;
        }
        return saveSentences(wordSentences);
    }

    private int saveSentences(List<WordSentence> wordSentences){
        logger.info("start to save sentences size is [{}]",wordSentences.size());

        return wordSentenceMapper.batchInsertSentences(wordSentences);
    }
}
