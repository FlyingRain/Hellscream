package com.flyingrain.translate.words.collection.service.collect.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flyingrain.translate.words.collection.service.collect.CollectWords;
import com.flyingrain.translate.words.collection.service.collect.impl.channel.shanbei.worddifine.QueryResult;
import com.flyingrain.translate.words.collection.service.collect.impl.filehandler.FileHandler;
import com.flyingrain.translate.words.collection.service.collect.impl.filehandler.impl.XlsHandler;
import com.flyingrain.translate.words.collection.service.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by wally on 4/10/17.
 */
@Component
public class CollectWordsImpl implements CollectWords {

    private Logger logger = LoggerFactory.getLogger(CollectWordsImpl.class);
    @Autowired
    private Environment environment;

    @Autowired
    private AudioSaver audioSaver;

    public void collect(String path) {
        collect(path,WordType.BASIC.type);
    }

    @Override
    public void collect(String path, int type) {
        if (StringUtils.isEmpty(path)) {
            logger.error("wrong file path ! file path cannot be null!");
            return;
        }
        FileHandler fileHandler = createFileHandler(path);
        int allNum = fileHandler.getAllNum(path);
        int maxLoad = 2000;
        try {
            maxLoad = Integer.parseInt(environment.getProperty("file.maxLoad"));
            if (maxLoad < 1) {
                throw new Exception("error maxLoad:" + maxLoad);
            }
        } catch (Exception e) {
            logger.warn("maxLoad is invalid! " + environment.getProperty("file.maxLoad") + ",use default value 2000!", e);
        }
        if(Counter.isEnd(maxLoad,allNum)){
            return;
        }
        List<String> words = fileHandler.handleFile(path, Counter.getNowCount(), maxLoad);
        collect(words,type);
    }

    public void collect(List<String> words,int type) {

        String result = HttpUtil.sendGet("https://api.shanbay.com/bdc/search/?word=good");
        audioSaver.saveAudiobyUrl("http://media-audio1.qiniu.baydn.com/uk/v/vo/vocabulary_v3.mp3");
        QueryResult queryResult = paraseResult(result);
    }

    private QueryResult paraseResult(String result) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        try {
            logger.info("start parse result!");
            return objectMapper.readValue(result, QueryResult.class);
        } catch (IOException e) {
            logger.error("parse result error!result is [{}]", result, e);
        }
        return null;
    }


    private FileHandler createFileHandler(String path) {
        return new XlsHandler();
    }

}
