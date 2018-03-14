package com.flyingrain.translate.dungeon.service.services.dao.mapper;

import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonInstanceModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wally on 9/11/17.
 */
public interface DungeonInstanceMapper {

    /**
     * 插入副本实例
     *
     * @param dungeonInstanceModel
     * @return
     */
    @Insert("insert into dungeon_instance (dungeon_resource,enroll_time,end_time,dungeon_status) values " +
            "(#{dungeonInstanceModel.dungeon_source},#{dungeonInstanceModel.enroll_time},#{dungeonInstanceModel.end_time},#{dungeonInstanceModel.dungeon_status})")
    @Options(useGeneratedKeys = true, keyProperty = "dungeonInstanceModel.id")
    int insertDungeonInstance(@Param("dungeonInstanceModel") DungeonInstanceModel dungeonInstanceModel);

    /**
     * 根据实例Id查询副本Id
     *
     * @param id
     * @return
     */
    @Select("select dungeon_source from dungeon_instance where id=#{instanceId}")
    int dungeonId(@Param("instanceId") int id);


    /**
     * 根据副本模板Id和状态获取副本实例
     *
     * @param dungonId
     * @return
     */
    @Select("select dungeon_source,enroll_time,start_time,end_time,dungeon_status from dungeon_instance where dungeon_source=#{dungeonId} and dungeon_status=#{status}")
    List<DungeonInstanceModel> dungeonInstanceByModelId(@Param("dungeonId") int dungonId, @Param("status") int status);

}
