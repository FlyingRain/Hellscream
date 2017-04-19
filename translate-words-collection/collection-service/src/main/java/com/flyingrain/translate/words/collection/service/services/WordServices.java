package com.flyingrain.translate.words.collection.service.services;

import com.flyingrain.translate.words.collection.model.WordResult;
import com.flyingrain.translate.words.collection.model.SentenceDefine;

/**
 * Created by wally on 4/18/17.
 */
public interface WordServices {

    WordResult getWord(String word,int type);

    SentenceDefine getSentence(int wordId);
}
