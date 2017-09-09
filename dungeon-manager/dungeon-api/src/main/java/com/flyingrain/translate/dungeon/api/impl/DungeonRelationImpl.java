package com.flyingrain.translate.dungeon.api.impl;

import com.flyingrain.translate.dungeon.api.domain.DungeonRelation;
import com.flyingrain.translate.dungeon.api.mapper.DungeonRelationMapper;
import com.flyingrain.translate.dungeon.api.service.DungeonRelationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Uni on 2017/9/9.
 */
public class DungeonRelationImpl implements DungeonRelationService {

    @Autowired
    private DungeonRelationMapper dungeonRelationMapper;

    @Override
    public DungeonRelation getRoleRelation(int dungeonId) {
        return dungeonRelationMapper.getRoleRelation(dungeonId);
    }

    @Override
    public DungeonRelation getDungeonRelation(int roleId) {
        return dungeonRelationMapper.getDungeonRelation(roleId);
    }

    @Override
    public List<DungeonRelation> getList(int page) {
        return dungeonRelationMapper.getList(page);
    }
}
