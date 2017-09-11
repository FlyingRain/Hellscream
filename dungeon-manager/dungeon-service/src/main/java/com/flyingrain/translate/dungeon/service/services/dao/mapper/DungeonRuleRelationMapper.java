package com.flyingrain.translate.dungeon.service.services.dao.mapper;

import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleRelationModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

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





}
