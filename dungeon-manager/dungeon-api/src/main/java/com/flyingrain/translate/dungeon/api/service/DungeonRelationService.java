package com.flyingrain.translate.dungeon.api.service;

import com.flyingrain.translate.dungeon.api.domain.DungeonRelation;

import java.util.List;

/**
 * Created by Uni on 2017/9/9.
 */
public interface DungeonRelationService {

    DungeonRelation getRoleRelation(int dungeonId);

    DungeonRelation getDungeonRelation(int roleId);

    List<DungeonRelation> getList(int page);
}
