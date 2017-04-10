package com.flyingrain.translate.database.conf.aspect;

import com.flyingrain.translate.database.conf.DataBaseContextHolder;
import com.flyingrain.translate.database.conf.DataSourceName;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 4/10/17.
 */
@Aspect
@Order(-1) //在transaction 注入之前加入切面
@Component
public class DynamicDataSourceAspect {

    private Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(dataSourceName)")
    public void changeDataSource(JoinPoint point,DataSourceName dataSourceName){
        String sourceName = dataSourceName.value();
        logger.info("set dataSource to :" + sourceName);
        DataBaseContextHolder.setDatabase(sourceName);
    }

    @After("@annotation(dataSourceName)")
    public void clearDatasourceHolder(JoinPoint joinPoint,DataSourceName dataSourceName){
        logger.info("Revert datasource to :" + joinPoint.getSignature());

        DataBaseContextHolder.clearDatasourceHolder();
    }
}
