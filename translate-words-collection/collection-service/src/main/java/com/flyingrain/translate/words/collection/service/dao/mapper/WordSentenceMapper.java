package com.flyingrain.translate.words.collection.service.dao.mapper;

import com.flyingrain.translate.words.collection.service.dao.mapper.providers.WordSentenceProvider;
import com.flyingrain.translate.words.collection.service.dao.model.WordSentence;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wally on 4/17/17.
 */
public interface WordSentenceMapper {

    @Insert("insert into word_sentence (sentence,transaction,like,unlike,word_id,channel_id,first,last,word) values" +
            "     (#{wordSentence.sentence},#{wordSentence.transaction},#{wordSentence.like},#{wordSentence.unlike}," +
            "#{wordSentence.word_id},#{wordSentence.channel_id},#{wordSentence.first},#{wordSentence.last},#{wordSentence.word})")
    int insertWordSentence(@Param("wordSentence") WordSentence wordSentence);


    @InsertProvider(type = WordSentenceProvider.class,method = "batchInsert")
    int batchInsertSentences(@Param("wordSentences")List<WordSentence> wordSentences);

    @Select("select * from word_sentence where word_id=#{wordId}")
    WordSentence getSentenceByWordId(String wordId);
}
