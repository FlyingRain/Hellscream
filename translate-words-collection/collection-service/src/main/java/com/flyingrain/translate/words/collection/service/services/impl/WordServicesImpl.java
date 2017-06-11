package com.flyingrain.translate.words.collection.service.services.impl;

import com.flyingrain.translate.words.collection.result.WordResult;
import com.flyingrain.translate.words.collection.service.collect.CollectWords;
import com.flyingrain.translate.words.collection.service.common.AudioType;
import com.flyingrain.translate.words.collection.service.dao.mapper.AudioMapper;
import com.flyingrain.translate.words.collection.service.dao.mapper.ENMeanMapper;
import com.flyingrain.translate.words.collection.service.dao.mapper.WordMapper;
import com.flyingrain.translate.words.collection.service.dao.mapper.WordSentenceMapper;
import com.flyingrain.translate.words.collection.service.dao.model.Audio;
import com.flyingrain.translate.words.collection.service.dao.model.ENMean;
import com.flyingrain.translate.words.collection.service.dao.model.Word;
import com.flyingrain.translate.words.collection.service.dao.model.WordSentence;
import com.flyingrain.translate.words.collection.service.services.WordServices;
import com.flyingrain.translate.words.collection.result.SentenceDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wally on 4/18/17.
 */
@Component
public class WordServicesImpl implements WordServices {

    private Logger logger = LoggerFactory.getLogger(WordServicesImpl.class);

    @Autowired
    private WordMapper wordMapper;
    @Autowired
    private ENMeanMapper enMeanMapper;
    @Autowired
    private CollectWords collectWords;
    @Autowired
    private AudioMapper audioMapper;
    @Autowired
    private WordSentenceMapper wordSentenceMapper;

    @Override
    public WordResult getWord(String word, int type) {
        Word myWord = wordMapper.getWord(word);
        //如果数据库中没有单词，则去渠道查询，然后再去数据库中查询
        if (myWord == null) {
            logger.info("there is no word in database! to get it from channel![{}]", word);
            List<String> words = new ArrayList<>();
            words.add(word);
            collectWords.collect(words, type);
            myWord = wordMapper.getWord(word);
            //如果渠道收集不到则报错
            if (myWord == null) {
                //CollectWords.errorWords.add(word);
                logger.error("no word to be found![{}]", word);
                return null;
            }
        }
        return transfer(myWord);
    }

    @Override
    public SentenceDefine getSentence(int wordId) {
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

    private WordResult transfer(Word myWord) {
        WordResult wordResult = new WordResult();
        wordResult.setWord(myWord.getWord());
        wordResult.setMean(myWord.getMean());
        wordResult.setUkPronunciation(myWord.getUk_pronunciation());
        wordResult.setUsPronunciation(myWord.getUs_pronunciation());
        wordResult.setWordId(myWord.getId());
        ENMean enMean = enMeanMapper.getMeanByWordId(myWord.getId());
        if (enMean != null) {
            if (!StringUtils.isEmpty(enMean.getAdj()))
                wordResult.setAdj(Arrays.asList(enMean.getAdj().split("\\|")));
            if (!StringUtils.isEmpty(enMean.getAdv()))
                wordResult.setAdv(Arrays.asList(enMean.getAdv().split("\\|")));
            if (!StringUtils.isEmpty(enMean.getN()))
                wordResult.setN(Arrays.asList(enMean.getN().split("\\|")));
            if (!StringUtils.isEmpty(enMean.getV()))
                wordResult.setV(Arrays.asList(enMean.getV().split("\\|")));
        } else {
            logger.warn("no enMean to be found! [{}]", myWord);
        }
        List<String> usAudios = new ArrayList<>();
        List<String> ukAudios = new ArrayList<>();
        Audio usAudio = audioMapper.getAudioByWordIdAndType(myWord.getId(), AudioType.US_AUDIO.type);
        Audio ukAudio = audioMapper.getAudioByWordIdAndType(myWord.getId(), AudioType.UK_AUDIO.type);
        if (usAudio == null) {
            logger.warn("no usAudio to be found! wordId [{}]", myWord.getId());
        } else if (StringUtils.isEmpty(usAudio.getAudio_address())) {
            usAudios.addAll(Arrays.asList(usAudio.getChannel_audio_address().split("\\|")));
        } else {
            usAudios.addAll(Arrays.asList(usAudio.getAudio_address().split("\\|")));
        }

        if (ukAudio == null) {
            logger.warn("no ukAudio to be found! wordId [{}]", myWord.getId());
        } else if (StringUtils.isEmpty(ukAudio.getAudio_address())) {
            ukAudios.addAll(Arrays.asList(ukAudio.getChannel_audio_address().split("\\|")));
        } else {
            ukAudios.addAll(Arrays.asList(ukAudio.getAudio_address().split("\\|")));
        }
        wordResult.setUsAudio(usAudios);
        wordResult.setUkAudio(ukAudios);
        return wordResult;
    }

    @Override
    public WordResult getWordById(int wordId) {
        Word myWord = wordMapper.getWordById(wordId);
        if(myWord==null){
            logger.error("no word exist! wordId is [{}]",wordId);
        }

        return transfer(myWord);
    }
}
