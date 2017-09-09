package com.flyingrain.translate.dungeon.api.mapper;

import com.flyingrain.translate.dungeon.api.domain.DungeonResource;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Uni on 2017/9/9.
 */
public interface DungeonResourceMapper {

    /**
     * 获取所有的静态数据
     * @return
     */
    @Select("select * from dungeon_resource")
    List<DungeonResource> list();

    /**
     * 根据id来获取
     * @param id
     * @return
     */
    @Select("select * from dungeon_resource where id=#{id}")
    DungeonResource getResource(@Param("id") int id);

}
