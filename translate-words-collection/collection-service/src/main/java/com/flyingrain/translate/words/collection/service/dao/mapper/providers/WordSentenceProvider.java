package com.flyingrain.translate.words.collection.service.dao.mapper.providers;

import com.flyingrain.translate.words.collection.service.dao.model.WordSentence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by wally on 4/17/17.
 */
public class WordSentenceProvider {

    private Logger logger = LoggerFactory.getLogger(WordSentenceProvider.class);

    public String batchInsert(Map param){
        logger.info("start to generate sql !");
        List<WordSentence> wordSentences = (List<WordSentence>) param.get("wordSentences");
        StringBuilder stringBuilder = new StringBuilder("insert into word_sentence (sentence,transaction,like,unlike,word_id,channel_id,first,last,word) values ");
        wordSentences.forEach(wordSentence -> {
            stringBuilder.append("(");
            stringBuilder.append("'"+wordSentence.getSentence()+"',");
            stringBuilder.append("'"+wordSentence.getTransaction()+"',");
            stringBuilder.append(wordSentence.getLike()+",");
            stringBuilder.append(wordSentence.getUnlike()+",");
            stringBuilder.append(wordSentence.getWord_id()+",");
            stringBuilder.append(wordSentence.getChannel_id()+",");
            stringBuilder.append("'"+wordSentence.getFirst()+"',");
            stringBuilder.append("'"+wordSentence.getLast()+"',");
            stringBuilder.append("'"+wordSentence.getWord()+"',");
            stringBuilder.append("),");
        });
        String sql = stringBuilder.substring(0,stringBuilder.length()-1);

        logger.info("get sql [{}]",sql);
        return sql;
    }

}
