package com.flyingrain.translate.dungeon.service.services.dao.mapper;

import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonInstanceContainerModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
 * 副本容器
 * Created by wally on 11/8/17.
 */
public interface DungeonInstanceContainerMapper {

    @Insert("insert into dungeon_instance_container (dungeon_instance_id,plan_id,user_id,status) values" +
            "(#{containerModel.dungeon_instance_id},#{containerModel.plan_id},#{containerModel.user_id},#{containerModel.status})" )
    @Options(useGeneratedKeys = true,keyProperty = "containerModel.id")
    int userJoinDungeon(@Param("containerModel")DungeonInstanceContainerModel containerModel);



}
