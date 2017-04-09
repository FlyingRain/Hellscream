package com.flyingrain.translate.database.conf.test.data;

import com.flyingrain.translate.database.conf.DataSourceName;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 4/7/17.
 */
@Component
public class Dao1 {

    @DataSourceName("test2")
    public void test(){

    }
}
