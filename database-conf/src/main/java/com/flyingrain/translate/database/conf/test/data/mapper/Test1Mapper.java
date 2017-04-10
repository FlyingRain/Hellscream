package com.flyingrain.translate.database.conf.test.data.mapper;

import com.flyingrain.translate.database.conf.test.data.Model;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wally on 4/10/17.
 */
public interface Test1Mapper {

    @Select("select * from test")
    Model setectAll();

}
