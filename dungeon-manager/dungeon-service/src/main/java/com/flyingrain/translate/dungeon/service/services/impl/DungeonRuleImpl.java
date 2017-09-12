package com.flyingrain.translate.dungeon.service.services.impl;

import com.flyingrain.translate.dungeon.service.services.DungeonRuleService;
import com.flyingrain.translate.dungeon.service.services.dao.mapper.DungeonRuleMapper;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Uni on 2017/9/11.
 */
@Component
public class DungeonRuleImpl implements DungeonRuleService {

    @Autowired
    private DungeonRuleMapper dungeonRuleMapper;

    @Override
    public DungeonRuleModel getRule(int id) {
        return dungeonRuleMapper.getRuleById(id);
    }

    @Override
    public int updateRule(int id, int isActive, String range) {
        return dungeonRuleMapper.updateRule(id, isActive, range);
    }

    @Override
    public int deleteRule(int id) {
        return dungeonRuleMapper.deleteRuleById(id);
    }
}
