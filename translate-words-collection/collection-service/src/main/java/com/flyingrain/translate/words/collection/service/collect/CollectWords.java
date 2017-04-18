package com.flyingrain.translate.words.collection.service.collect;

import com.flyingrain.translate.words.collection.service.collect.impl.words.WrongWord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wally on 4/10/17.
 */
public interface CollectWords {

    List<WrongWord> errorWords = new ArrayList<>();

    void collect(String path);

    void collect(String path, int type);

    void collect(List<String> words, int type);

}
