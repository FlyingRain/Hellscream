package com.flyingrain.translate.database.conf;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by wally on 4/7/17.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 设置使用的数据源
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataBaseContextHolder.getDataBaseName();
    }

}
