package com.flyingrain.translate.dungeon.service.services.impl;

import com.flyingrain.translate.dungeon.service.services.DungeonRuleRelationService;
import com.flyingrain.translate.dungeon.service.services.dao.mapper.DungeonRuleRelationMapper;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleRelationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Uni on 2017/9/11.
 */
@Component
public class DungeonRuleRelationImpl implements DungeonRuleRelationService {

    @Autowired
    private DungeonRuleRelationMapper dungeonRuleRelationMapper;

    @Override
    public DungeonRuleRelationModel getRuleRelation(int dungeonId) {
        return dungeonRuleRelationMapper.getRuleRelationByDungeonId(dungeonId);
    }

    @Override
    public DungeonRuleRelationModel getDungeonRelation(int ruleId) {
        return dungeonRuleRelationMapper.getDungeonRelationByRuleId(ruleId);
    }

    @Override
    public List<DungeonRuleRelationModel> getList(int page) {
        return dungeonRuleRelationMapper.getList(page);
    }

    @Override
    public int deleteRelation(int id) {
        return dungeonRuleRelationMapper.deleteRelationById(id);
    }
}
