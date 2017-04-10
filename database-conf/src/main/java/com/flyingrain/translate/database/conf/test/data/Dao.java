package com.flyingrain.translate.database.conf.test.data;

import com.flyingrain.translate.database.conf.DataSourceName;
import com.flyingrain.translate.database.conf.test.data.mapper.Test1Mapper;
import com.flyingrain.translate.database.conf.test.data.mapper.Test2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 4/7/17.
 */
@Component
public class Dao {

    @Autowired
    private Test1Mapper test1Mapper;
    @Autowired
    private Test2Mapper test2Mapper;

    public void test(){
        Model model = test1Mapper.setectAll();
        System.out.println(model.getName());
    }

    @DataSourceName("test")
    public void test2(){
        Model model = test2Mapper.setectAll();
        System.out.println(model.getName());
    }
}
