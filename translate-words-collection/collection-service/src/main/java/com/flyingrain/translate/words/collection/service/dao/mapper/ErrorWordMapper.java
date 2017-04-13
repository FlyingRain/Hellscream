package com.flyingrain.translate.words.collection.service.dao.mapper;

import com.flyingrain.translate.words.collection.service.dao.model.ErrorWord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wally on 4/13/17.
 */
public interface ErrorWordMapper {

    @Insert("insert into error_words (word,type,error_msg,error_code) values" +
            "  (#{errorWord.word},#{errorWord.type},#{errorWord.error_msg},#{errorWord.error_code})")
    int insertErrorWord(@Param("errorWord") ErrorWord errorWord);

    @Select("select * from error_words where word=#{word}")
    ErrorWord getErrorWord(String word);
}
