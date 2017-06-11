package com.flyingrain.translate.words.collection.service.services;

import com.flyingrain.translate.words.collection.result.WordResult;
import com.flyingrain.translate.words.collection.result.SentenceDefine;

/**
 * Created by wally on 4/18/17.
 */
public interface WordServices {
    /**
     * 根据单词和类型查询单词
     * @param word
     * @param type
     * @return
     */
    WordResult getWord(String word,int type);

    /**
     * 根据单词Id查询例句
     * @param wordId
     * @return
     */
    SentenceDefine getSentence(int wordId);

    /**
     * 根据单词Id查询单词
     * @param wordId
     * @return
     */
    WordResult getWordById(int wordId);
}
