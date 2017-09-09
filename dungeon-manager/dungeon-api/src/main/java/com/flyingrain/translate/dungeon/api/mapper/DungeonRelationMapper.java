package com.flyingrain.translate.dungeon.api.mapper;

import com.flyingrain.translate.dungeon.api.domain.DungeonRelation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Uni on 2017/9/9.
 */
public interface DungeonRelationMapper {

    /**
     * 根据roleId查找
     * @param roleId
     * @return
     */
    @Select("select * from dungeon_role_relation where role_id=#{roleId}")
    DungeonRelation getDungeonRelation(@Param("roleId") int roleId);

    /**
     * 根据dungeonId查找
     * @param dungeonId
     * @return
     */
    @Select("select * from dungeon_role_relation where dungeon_id=#{dungeonId}")
    DungeonRelation getRoleRelation(@Param("dungeonId") int dungeonId);

    /**
     * 分页查找全部
     * @return
     */
    @Select("select * from dungeon_role_relation order by data_added desc limit (#{page}-1)*10,10")
    List<DungeonRelation> getList(int page);
}
