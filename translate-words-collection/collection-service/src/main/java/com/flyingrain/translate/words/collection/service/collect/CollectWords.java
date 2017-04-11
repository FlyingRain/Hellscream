package com.flyingrain.translate.words.collection.service.collect;

import java.util.List;

/**
 * Created by wally on 4/10/17.
 */
public interface CollectWords {

    void collect(String path);

    void collect(String path,int type);

    void collect(List<String> words,int type);
}
