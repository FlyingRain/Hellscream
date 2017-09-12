package com.flyingrain.translate.dungeon.service.services.dao.mapper;

import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleRelationModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wally on 9/11/17.
 */
public interface DungeonRuleRelationMapper {

    /**
     * 插入副本规则映射
     * @param relationModel
     * @return
     */
    @Insert("insert into dungeon_rule_relation (dungeon_id,rule_id,is_active) values(#{relationModel.dungeon_id},#{" +
            "relationModel.rule_id},#{relationModel.is_active})")
    int insertRuleRelation(@Param("relationModel") DungeonRuleRelationModel relationModel);


    /**
     * 根据roleId查找
     * @param ruleId
     * @return
     */
    @Select("select * from dungeon_rule_relation where rule_id=#{ruleId}")
    DungeonRuleRelationModel getDungeonRelationByRuleId(@Param("ruleId") int ruleId);

    /**
     * 根据dungeonId查找
     * @param dungeonId
     * @return
     */
    @Select("select * from dungeon_rule_relation where dungeon_id=#{dungeonId}")
    DungeonRuleRelationModel getRuleRelationByDungeonId(@Param("dungeonId") int dungeonId);

    /**
     * 分页查找全部
     * @return
     */
    @Select("select * from dungeon_role_relation order by data_added desc limit (#{page}-1)*10,10")
    List<DungeonRuleRelationModel> getList(@Param("page") int page);

    /**
     * 删除关系
     * @param id
     * @return
     */
    @Delete("delete from dungeon_rule_relation where id=#{id}")
    int deleteRelationById(@Param("id") int id);



}
