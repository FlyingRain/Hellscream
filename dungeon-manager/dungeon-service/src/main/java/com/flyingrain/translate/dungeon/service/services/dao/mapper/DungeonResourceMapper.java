package com.flyingrain.translate.dungeon.service.services.dao.mapper;

import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonResourceModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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


}
