package com.flyingrain.translate.dungeon.service.services.impl.dungeonInstance;

import com.flyingrain.translate.dungeon.api.domain.DungeonLimit;
import com.flyingrain.translate.dungeon.service.services.common.ActiveEnum;
import com.flyingrain.translate.dungeon.service.services.dao.mapper.DungeonResourceMapper;
import com.flyingrain.translate.dungeon.service.services.dao.mapper.DungeonRuleMapper;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonInstanceModel;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonResourceModel;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 副本建造者
 * Created by wally on 3/16/18.
 */
@Component
public class DungeonInstanceBuilderImpl implements DungeonInstanceBuilder {

    private Logger logger = LoggerFactory.getLogger(DungeonInstanceBuilderImpl.class);

    @Autowired
    private DungeonRuleMapper dungeonRuleMapper;

    @Autowired
    private DungeonResourceMapper resourceMapper;

    @Override
    public List<DungeonLimit> dungeonLimits(int dungeonModelId) {
        List<DungeonRuleModel> ruleModels = dungeonRuleMapper.getRulesByDungeonId(dungeonModelId, ActiveEnum.ACTIVE.ordinal());
        return ruleModels.stream().map(model -> {
            DungeonLimit limit = new DungeonLimit();
            limit.setDesc(model.getRule());
            limit.setType(model.getRule_type());
            limit.setValue(model.getRule_param());
            return limit;
        }).collect(Collectors.toList());
    }

    @Override
    public DungeonResourceModel dungeonModel(int dungeonModelId) {
        return resourceMapper.getByDungeonId(dungeonModelId);
    }

    @Override
    public DungeonInstanceModel dungeonInstance(int dungeonInstanceId) {
        return null;
    }
}
