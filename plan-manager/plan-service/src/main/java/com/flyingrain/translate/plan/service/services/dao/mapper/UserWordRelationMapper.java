package com.flyingrain.translate.plan.service.services.dao.mapper;

import com.flyingrain.translate.plan.service.services.dao.model.UserWordRelation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by wally on 4/25/17.
 */
public interface UserWordRelationMapper {

    @Insert("insert into user_word_relation (user_id,word_id,proficiency values " +
            "(#{userWordRelation.user_id},#{userWordRelation.word_id},#{userWordRelation.proficiency}))")
    int insertProficiency(@Param("userWordRelation")UserWordRelation wordRelation);

    @Select("select user_id,word_id,proficiency from user_word_relation where user_id=#{userId} and word_id=#{wordId})")
    int getproficiency(@Param("userId")int userId,@Param("wordId")int wordId);

    @Update("update user_word_relation set proficiency=#{userWordRelation} where user_id=#{userWordRelation.user_id} and word_id=#{userWordRelation.word_id}")
    int updateproficiency(@Param("userWordRelation") UserWordRelation wordRelation);
}
