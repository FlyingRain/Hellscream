package com.flyingrain.translate.words.collection.service.services;

import com.flyingrain.translate.words.collection.model.WordResult;

/**
 * Created by wally on 4/18/17.
 */
public interface WordServices {

    WordResult getWord(String word,int type);
}
