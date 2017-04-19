package com.flyingrain.translate.words.collection.service.collect.impl;

import com.flyingrain.translate.words.collection.service.collect.CollectSentences;
import com.flyingrain.translate.words.collection.service.collect.impl.channel.ChannelCollectSentence;
import com.flyingrain.translate.words.collection.service.collect.impl.channel.QueryRequest;
import com.flyingrain.translate.words.collection.service.words.Result;
import com.flyingrain.translate.words.collection.model.SentenceDefine;
import com.flyingrain.translate.words.collection.service.dao.mapper.WordMapper;
import com.flyingrain.translate.words.collection.service.dao.model.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wally on 4/17/17.
 */
@Component
public class CollectSentencesImpl implements CollectSentences {

    private Logger logger = LoggerFactory.getLogger(CollectSentencesImpl.class);
    @Autowired
    private ChannelCollectSentence channelCollectSentence;
    @Autowired
    private WordMapper wordMapper;
    @Autowired
    private SentenceManager sentenceManager;

    @Override
    public void collectSentences() {
        List<Word> words = wordMapper.getNoSentenceWords();
        if (words.size() < 1) {
            logger.info("no words to be collect!");
            return;
        }
        words.forEach(word -> {
            QueryRequest queryRequest = new QueryRequest();
            queryRequest.setWord(word.getWord());
            queryRequest.setId(word.getId() + "");
            queryRequest.setChannelWordId(word.getChannel_word_id());
            Result<SentenceDefine> result = channelCollectSentence.querySentence(queryRequest);
            if (result != null)
                sentenceManager.saveSentence(result.getQueryResult());
            else
                logger.error("query result is null![{}]",word);
        });


    }
}
