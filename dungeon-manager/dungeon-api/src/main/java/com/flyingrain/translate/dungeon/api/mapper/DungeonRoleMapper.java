package com.flyingrain.translate.dungeon.api.mapper;

import com.flyingrain.translate.dungeon.api.domain.DungeonRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Uni on 2017/9/9.
 */
public interface DungeonRoleMapper {

    @Select("select * from dungeon_role where id=#{id}")
    DungeonRole getRole(@Param("id") int id);
}
