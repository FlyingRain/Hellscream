package com.flyingrain.translate.words.collection.service.dao.mapper.providers;

import com.flyingrain.translate.words.collection.service.dao.model.WordSentence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by wally on 4/17/17.
 */
public class WordSentenceProvider {

    private Logger logger = LoggerFactory.getLogger(WordSentenceProvider.class);

    public String batchInsert(Map param) {
        logger.info("start to generate sql !");
        List<WordSentence> wordSentences = (List<WordSentence>) param.get("wordSentences");
        StringBuilder stringBuilder = new StringBuilder("insert into word_sentence (sentence,`transaction`,`like`,unlike,word_id,channel_id,first,last,word) values ");
        //消息格式化.
        MessageFormat fm = new MessageFormat("(#'{'wordSentences[{0}].sentence},#'{'wordSentences[{0}].transaction},#'{'wordSentences[{0}].like}," +
                "#'{'wordSentences[{0}].unlike},#'{'wordSentences[{0}].word_id},#'{'wordSentences[{0}].channel_id},#'{'wordSentences[{0}].first},#'{'wordSentences[{0}].last},#'{'wordSentences[{0}].word})");

        for (int i = 0; i < wordSentences.size(); i++) {
            stringBuilder.append(fm.format(new Object[]{i}));
            if (i < wordSentences.size() - 1)
                stringBuilder.append(",");
        }

        String sql = stringBuilder.toString();

        logger.info("get sql [{}]", sql);
        return sql;
    }

}
