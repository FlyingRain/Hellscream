package com.flyingrain.translate.words.collection.service.services.impl;

import com.flyingrain.translate.words.collection.result.SentenceDefine;
import com.flyingrain.translate.words.collection.service.dao.mapper.AudioMapper;
import com.flyingrain.translate.words.collection.service.dao.mapper.ENMeanMapper;
import com.flyingrain.translate.words.collection.service.dao.mapper.WordMapper;
import com.flyingrain.translate.words.collection.service.dao.mapper.WordSentenceMapper;
import com.flyingrain.translate.words.collection.service.dao.model.Audio;
import com.flyingrain.translate.words.collection.service.dao.model.ENMean;
import com.flyingrain.translate.words.collection.service.dao.model.Word;
import com.flyingrain.translate.words.collection.service.dao.model.WordSentence;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词组装实例
 * Created by wally on 11/22/17.
 */
@Component
public class WordDefaultBuilder implements WordBuilder {

    private Logger logger = LoggerFactory.getLogger(WordDefaultBuilder.class);
    @Autowired
    private WordMapper wordMapper;
    @Autowired
    private ENMeanMapper enMeanMapper;
    @Autowired
    private AudioMapper audioMapper;
    @Autowired
    private WordSentenceMapper wordSentenceMapper;

    @Override
    public ENMean wordEnMean(int wordId) {
        return enMeanMapper.getMeanByWordId(wordId);
    }

    @Override
    public List<Audio> wordAudio(int wordId) {
        return audioMapper.wordAudios(wordId);
    }

    @Override
    public Word getWord(int wordId) {
        return wordMapper.getWordById(wordId);
    }

    @Override
    public SentenceDefine wordSentence(int wordId) {
        SentenceDefine sentenceDefine = new SentenceDefine();
        List<WordSentence> wordSentences = wordSentenceMapper.getSentenceByWordId(wordId);
        if (CollectionUtils.isEmpty(wordSentences)) {
            logger.warn("there is no sentence is database! wordId is [{}]", wordId);
            return null;
        }
        List<SentenceDefine.Mysentence> mysentences = new ArrayList<>();
        wordSentences.forEach(wordSentence -> {
            SentenceDefine.Mysentence mysentence = sentenceDefine.getMySentenceInstance();
            mysentence.setFirst(wordSentence.getFirst());
            mysentence.setLast(wordSentence.getLast());
            mysentence.setLike(wordSentence.getLike());
            mysentence.setUnlike(wordSentence.getUnlike());
            mysentence.setTranslation(wordSentence.getTransaction());
            logger.info("get sentence :[{}]", wordSentence);
            mysentences.add(mysentence);
        });
        sentenceDefine.setWordId(wordId);
        sentenceDefine.setWord(wordSentences.get(0).getWord());
        sentenceDefine.setMysentences(mysentences);
        return sentenceDefine;
    }
}
