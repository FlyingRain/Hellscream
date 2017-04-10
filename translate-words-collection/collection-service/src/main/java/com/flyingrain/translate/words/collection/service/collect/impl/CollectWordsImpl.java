package com.flyingrain.translate.words.collection.service.collect.impl;

import com.flyingrain.translate.words.collection.service.collect.CollectWords;
import com.flyingrain.translate.words.collection.service.utils.HttpUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wally on 4/10/17.
 */
@Component
public class CollectWordsImpl implements CollectWords{

    public void collect(String path) {
       String result = HttpUtil.sendGet("https://api.shanbay.com/bdc/search/?word=good");
    }

    public void collect(List<String> words) {

    }



}
