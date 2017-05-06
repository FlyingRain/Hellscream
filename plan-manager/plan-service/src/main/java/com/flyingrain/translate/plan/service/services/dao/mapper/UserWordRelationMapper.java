package com.flyingrain.translate.plan.service.services.dao.mapper;

import com.flyingrain.translate.plan.service.services.dao.mapper.providers.UserWordRelationProvider;
import com.flyingrain.translate.plan.service.services.dao.model.UserWordRelation;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by wally on 4/25/17.
 */
public interface UserWordRelationMapper {

    /**
     * 为用户插入一条新单词
     * @param wordRelation
     * @return
     */
    @Insert("insert into user_word_relation (user_id,word_id,proficiency,plan_id) values " +
            "(#{userWordRelation.user_id},#{userWordRelation.word_id},#{userWordRelation.proficiency},#{userWordRelation.plan_id})")
    int insertProficiency(@Param("userWordRelation")UserWordRelation wordRelation);

    /**
     * 查询用户某个计划中某个单词的熟练度
     * @param userWordRelation
     * @return
     */
    @Select("select user_id,word_id,proficiency from user_word_relation where user_id=#{userWordRelation.userId} and word_id=#{userWordRelation.wordId} and plan_id=#{userWordRelation.plan_id})")
    int getproficiency(@Param("userWordRelation")UserWordRelation userWordRelation);

    /**
     * 更新某个单词的熟练度
     * @param wordRelation
     * @return
     */
    @Update("update user_word_relation set proficiency=#{userWordRelation} where user_id=#{userWordRelation.user_id} and word_id=#{userWordRelation.word_id}")
    int updateproficiency(@Param("userWordRelation") UserWordRelation wordRelation);

    /**
     * 查询某个计划的所有单词
     * @param userId
     * @param planId
     * @return
     */
    @Select("select user_id,plan_id,proficiency,word_id from user_word_relation where user_id=#{userId} and plan_id=#{planId} ")
    List<UserWordRelation> getPlanWords(@Param("userId") int userId,@Param("planId")int planId);

    /**
     * 批量插入数据
     * @param userWordRelations
     * @return
     */
    @InsertProvider(type = UserWordRelationProvider.class,method = "batchInsert")
    int batchInsert(@Param("userWordRelations")List<UserWordRelation> userWordRelations);

    
    int batchUpdate(@Param("userWordRelations") List<UserWordRelation> userWordRelations);
}
