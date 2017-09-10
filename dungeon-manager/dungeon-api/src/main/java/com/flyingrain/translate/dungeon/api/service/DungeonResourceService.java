package com.flyingrain.translate.dungeon.api.service;

import com.flyingrain.translate.dungeon.api.domain.DungeonResource;

/**
 * Created by Uni on 2017/9/9.
 */
public interface DungeonResourceService {

    /**
     * 根据id查找
     * @param id
     * @return
     */
    DungeonResource getResource(int id);

    /**
     * 删除对应的resource
     * @param id
     * @return
     */
    int deleteResource(int id);
}
