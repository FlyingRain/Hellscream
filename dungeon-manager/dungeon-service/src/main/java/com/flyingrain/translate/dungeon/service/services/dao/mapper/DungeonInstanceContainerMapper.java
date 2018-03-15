package com.flyingrain.translate.dungeon.service.services.dao.mapper;

import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonInstanceContainerModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 副本容器
 * Created by wally on 11/8/17.
 */
public interface DungeonInstanceContainerMapper {

    @Insert("insert into dungeon_instance_container (dungeon_instance_id,plan_id,user_id,status) values" +
            "(#{containerModel.dungeon_instance_id},#{containerModel.plan_id},#{containerModel.user_id},#{containerModel.status})")
    @Options(useGeneratedKeys = true, keyProperty = "containerModel.id")
    int userJoinDungeon(@Param("containerModel") DungeonInstanceContainerModel containerModel);


    /**
     * 查询计划在副本中的状态
     *
     * @return
     */
    @Select("select plan_id,user_id,status,remark,dungeon_instance_id from dungeon_instance_container where user_id=#{userId} and plan_id=#{planId}")
    DungeonInstanceContainerModel queryPlanStatus(@Param("userId") int userId, @Param("planId") int planId);

}
