package com.flyingrain.translate.words.collection.service.collect.impl;

import com.flyingrain.translate.words.collection.model.WordType;
import com.flyingrain.translate.words.collection.service.collect.CollectWords;
import com.flyingrain.translate.words.collection.service.collect.impl.channel.ChannelCollect;
import com.flyingrain.translate.words.collection.service.collect.impl.filehandler.FileHandler;
import com.flyingrain.translate.words.collection.service.collect.impl.filehandler.impl.XlsHandler;
import com.flyingrain.translate.words.collection.service.words.Result;
import com.flyingrain.translate.words.collection.service.words.WordDefine;
import com.flyingrain.translate.words.collection.service.words.WrongWord;
import com.flyingrain.translate.words.collection.service.common.AudioType;
import com.flyingrain.translate.words.collection.service.common.ErrorType;
import com.flyingrain.translate.words.collection.service.dao.model.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by wally on 4/10/17.
 */
@Component
public class CollectWordsImpl implements CollectWords {

    private Logger logger = LoggerFactory.getLogger(CollectWordsImpl.class);
    private Environment environment;
    private ChannelCollect channelCollect;
    private WordManager wordManager;

    @Autowired
    public CollectWordsImpl(Environment environment, ChannelCollect channelCollect, WordManager wordManager) {
        this.environment = environment;
        this.channelCollect = channelCollect;
        this.wordManager = wordManager;
    }



    public void collect(String path) {
        collect(path, WordType.BASIC.type);
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
        if (Counter.isEnd(maxLoad, allNum)) {
            return;
        }
        List<String> words = fileHandler.handleFile(path, Counter.getNowCount() == maxLoad ? 0 : Counter.getNowCount(), maxLoad);
        collect(words, type);
    }

    public void collect(List<String> words, int type) {
        words.forEach(word -> {
            if (word.trim().contains(" ")) {
                errorWords.add(new WrongWord(word, type, ErrorType.STRUCTURE_ERROR.msg, ErrorType.STRUCTURE_ERROR.code));
            } else {
                Word word1 = wordManager.isExistWord(word);
                if (word1 == null || !wordManager.isExistEnMean(word1.getId()) || (wordManager.isExistAudio(word1.getId(), AudioType.UK_AUDIO.type) == null) || (wordManager.isExistAudio(word1.getId(), AudioType.US_AUDIO.type) == null)) {
                    Result<WordDefine> commonResult = channelCollect.query(word);
                    WordDefine wordDefinition = commonResult.getQueryResult();
                    if (!commonResult.isSuccess()) {
                        errorWords.add(new WrongWord(word, type, commonResult.getMsg(), Integer.parseInt(commonResult.getCode())));
                    } else {
                        wordDefinition.setType(type);
                        boolean result = wordManager.saveWord(wordDefinition);
                        if (!result) {
                            logger.error("fail to save the word !" + word);
                        }
                    }
                } else {
                    logger.info("word has exist ! word:[{}]", word1.getWord());
                    wordManager.saveTypeRelations(type, word1.getId());
                }
            }
        });
        logger.info("errorWordNo : " + errorWords.size());
//        String result = HttpUtil.sendGet("https://api.shanbay.com/bdc/search/?word=good");
//        audioSaver.saveAudiobyUrl("http://media-audio1.qiniu.baydn.com/uk/v/vo/vocabulary_v3.mp3");
        if (errorWords.size() > 0) {
                errorWords.forEach(errorWord -> {
                            logger.info("start to save errorWord: [{}]", errorWord);
                            wordManager.saveErrorWords(errorWord);
                        }
                );
                errorWords.clear();
            }

    }


    private FileHandler createFileHandler(String path) {
        return new XlsHandler();
    }


}
