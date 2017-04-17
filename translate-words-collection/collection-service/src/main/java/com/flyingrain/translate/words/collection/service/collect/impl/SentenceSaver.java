package com.flyingrain.translate.words.collection.service.collect.impl;

import com.flyingrain.translate.words.collection.service.collect.impl.words.SentenceDefine;
import com.flyingrain.translate.words.collection.service.dao.model.WordSentence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wally on 4/17/17.
 */
@Component
public class SentenceSaver {

    private Logger logger = LoggerFactory.getLogger(SentenceSaver.class);


    public int saveSentence(SentenceDefine sentenceDefine){
        List<WordSentence> wordSentences = new ArrayList<>();
        List<SentenceDefine.Mysentence> mysentences = sentenceDefine.getMysentences();

        mysentences.forEach(mysentence -> {
            WordSentence wordSentence = new WordSentence();
            wordSentence.setFirst(mysentence.getFirst());
            wordSentence.setLast(mysentence.getLast());
            wordSentence.setSentence(mysentence.getFirst()+" "+sentenceDefine.getChannelWordId()+" "+mysentence.getLast());
            wordSentence.setTransaction(mysentence.getTranslation());
            wordSentence.setLike(mysentence.getLike());
            wordSentence.setUnlike(mysentence.getUnlike());
            wordSentence.setWord(sentenceDefine.getWord());
            wordSentence.setWord_id(sentenceDefine.getWordId());
            wordSentences.add(wordSentence);
        });

        return saveSentences(wordSentences);
    }

    private int saveSentences(List<WordSentence> wordSentences){
        logger.info("start to save sentences size is [{}]",wordSentences.size());


        return 0;
    }
}
