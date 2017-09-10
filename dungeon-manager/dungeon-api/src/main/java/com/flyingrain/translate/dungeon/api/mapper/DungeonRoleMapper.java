package com.flyingrain.translate.dungeon.api.mapper;

import com.flyingrain.translate.dungeon.api.domain.DungeonRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by Uni on 2017/9/9.
 */
public interface DungeonRoleMapper {

    @Select("select * from dungeon_role where id=#{id}")
    DungeonRole getRole(@Param("id") int id);

    @Update("update dungeon_role set is_active=#{isActive}, role_param=#{range} where id=#{roleId}")
    int updateRole(@Param("roleId") int roleId, @Param("isActive") int isActive, @Param("range") int range);

    @Delete("delete from dungeon_role where id=#{id}")
    int deleteRole(@Param("id") int id);
}
