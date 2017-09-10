package com.flyingrain.translate.dungeon.service.impl;

import com.flyingrain.translate.dungeon.api.DungeonManagerResources;
import com.flyingrain.translate.dungeon.api.domain.DungeonDomain;
import com.flyingrain.translate.dungeon.api.requests.DungeonQueryRequest;
import com.flyingrain.translate.framework.annotaions.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 副本管理实现
 * Created by wally on 17-9-10.
 */
@Resource
@Component
public class DungeonManagerResourcesImpl implements DungeonManagerResources{
    @Override
    public int addDungeonModule(DungeonDomain dungeonDomain) {
        return 0;
    }

    @Override
    public int deleteDungeon(Integer dungeonId) {
        return 0;
    }

    @Override
    public List<DungeonDomain> pageQuery(DungeonQueryRequest queryRequest) {
        return null;
    }
}
