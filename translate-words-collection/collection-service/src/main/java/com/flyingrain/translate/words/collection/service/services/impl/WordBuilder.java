package com.flyingrain.translate.words.collection.service.services.impl;

import com.flyingrain.translate.words.collection.result.SentenceDefine;
import com.flyingrain.translate.words.collection.service.dao.model.Audio;
import com.flyingrain.translate.words.collection.service.dao.model.ENMean;
import com.flyingrain.translate.words.collection.service.dao.model.Word;

import java.util.List;

/**
 * 单词组装
 * Created by wally on 11/22/17.
 *
 */
public interface WordBuilder {

    /**
     * 获取单名英文意思
     * @param wordId
     * @return
     */
    ENMean wordEnMean(int wordId);

    /**
     * 获取单词英式发音
      * @param wordId
     * @return
     */
    List<Audio> wordAudio(int wordId);

    /**
     * 获取单词含义
     * @param wordId
     * @return
     */
    Word getWord(int wordId);

    /**
     * 获取单词例句
     * @param wordId
     * @return
     */
    SentenceDefine wordSentence(int wordId);
}
