package com.flyingrain.translate.database.conf.test.data.mapper;

import com.flyingrain.translate.database.conf.test.data.Model;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wally on 4/10/17.
 */
public interface Test1Mapper {

    /**
     * 测试mybatis插件
     * @param id
     * @param name
     * @return
     */
    @Select("select * from test where id=#{id} and name=#{name}")
    Model setectAll(@Param("id") int id, @Param("name") String name);

}
