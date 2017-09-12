package com.flyingrain.translate.dungeon.service.services.dao.mapper;

import com.flyingrain.translate.dungeon.api.domain.DungeonResource;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonResourceModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by wally on 9/11/17.
 */
public interface DungeonResourceMapper {

    /**
     * 插入一个副本模板
     * @param resourceModel
     * @return
     */
    @Insert("insert into dungeon_resource (title,desc,imgs) values (#{resourceModel.title},#{resourceModel.desc},#{resourceModel.imgs})")
    @Options(useGeneratedKeys = true,keyProperty = "resourceModel.id")
    int insertDungeonResource(@Param("resourceModel") DungeonResourceModel resourceModel);


    /**
     * 根据Id查询副本模板
     * @param id
     * @return
     */
    @Select("select id,title,desc,imgs,data_added,last_modified from dungeon_resource where id=#{id}")
    DungeonResourceModel getByDungeonId(int id);

    /**
     * 获取所有的模板
     * @return
     */
    @Select("select * from dungeon_resource")
    List<DungeonResource> list();

    /**
     * 删除一个模板
     * @param id
     * @return
     */
    @Delete("delete from dungeon_resource where id=#{id}")
    int deleteResourceById(@Param("id") int id);


}
