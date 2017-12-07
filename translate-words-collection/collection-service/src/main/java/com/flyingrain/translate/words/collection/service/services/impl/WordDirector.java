package com.flyingrain.translate.words.collection.service.services.impl;

import com.flyingrain.translate.words.collection.result.WordResult;
import com.flyingrain.translate.words.collection.service.common.AudioType;
import com.flyingrain.translate.words.collection.service.dao.model.Audio;
import com.flyingrain.translate.words.collection.service.dao.model.ENMean;
import com.flyingrain.translate.words.collection.service.dao.model.Word;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 单词组装导演类
 * Created by wally on 11/22/17.
 */
@Component
public class WordDirector {

    private Logger logger = LoggerFactory.getLogger(WordDirector.class);
    @Autowired
    private WordBuilder wordBuilder;


    public  WordResult buildWord(int wordId) {
        WordResult wordResult = new WordResult();
        wordResult.setSamples(wordBuilder.wordSentence(wordId));
        ENMean enMean = wordBuilder.wordEnMean(wordId);
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
            logger.warn("no enMean to be found! [{}]", wordId);
        }
        List<Audio> wordAudios = wordBuilder.wordAudio(wordId);

         Map<String, Optional<String>> result = new HashMap<>();
        if (CollectionUtils.isNotEmpty(wordAudios))
            result = wordAudios.stream().collect(Collectors.groupingBy(Audio::getAudio_type, Collectors.mapping(Audio::getChannel_audio_address, Collectors.reducing((a, b) -> a + "|" + b))));
        wordResult.setUkAudio(Arrays.asList(result.get(AudioType.UK_AUDIO.type).orElse("|").split("\\|")));
        wordResult.setUsAudio(Arrays.asList(result.get(AudioType.US_AUDIO.type).orElse("|").split("\\|")));
        Word word = wordBuilder.getWord(wordId);
        wordResult.setMean(word.getMean());
        wordResult.setWord(word.getWord());
        wordResult.setWordId(wordId);
        return wordResult;
    }


}



