package com.flyingrain.translate.words.collection.service.dao.mapper;

import com.flyingrain.translate.words.collection.service.dao.model.WordTypeRelations;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wally on 4/12/17.
 */
public interface WordTypeRelationsMapper {

    @Insert("insert into word_type_relations (word_id,type_code) values (#{wordId},#{typeCode})")
    int insertRelation(@Param("wordId") int wordId, @Param("typeCode") int typeCode);

    @Select("select * from word_type_relations where word_id=#{wordId} and type_code=#{typeCode}")
    WordTypeRelations getRelation(@Param("wordId") int wordId,@Param("typeCode") int typeCode);

    @Select("select count(1) from word_type_relations group by type_code having type_code=#{type}")
    Integer getTypeNumber(int type);

    @Select("select count(1) from (select  DISTINCT word_id from word_type_relations ) a")
    Integer getAllWords();

}
