package com.flyingrain.translate.database.conf.test.data.mapper;

import com.flyingrain.translate.database.conf.test.data.Model;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.ResultHandler;

/**
 * Created by wally on 4/10/17.
 */
public interface Test2Mapper {

    @Select("select * from test")
    @ResultType(Model.class)
    void setectAll(ResultHandler handler);

}
