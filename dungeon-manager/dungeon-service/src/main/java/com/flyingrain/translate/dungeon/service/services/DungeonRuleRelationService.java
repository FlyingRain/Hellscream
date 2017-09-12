package com.flyingrain.translate.dungeon.service.services;

import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleRelationModel;

import java.util.List;

/**
 * Created by Uni on 2017/9/11.
 */
public interface DungeonRuleRelationService {

    /**
     * 根据副本id查找
     * @param dungeonId
     * @return
     */
    DungeonRuleRelationModel getRuleRelation(int dungeonId);

    /**
     * 根据规则id查找
     * @param ruleId
     * @return
     */
    DungeonRuleRelationModel getDungeonRelation(int ruleId);

    /**
     * 分页查询
     * @param page
     * @return
     */
    List<DungeonRuleRelationModel> getList(int page);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteRelation(int id);

}
