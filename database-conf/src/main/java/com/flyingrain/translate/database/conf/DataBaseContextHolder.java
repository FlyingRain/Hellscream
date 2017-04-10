package com.flyingrain.translate.database.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据源线程容器
 * Created by wally on 4/7/17.
 */
public class DataBaseContextHolder {

    private static Logger logger = LoggerFactory.getLogger(DataBaseContextHolder.class);

    private static final ThreadLocal<String> database = new ThreadLocal<>();

    static List<String> dataSourceList = new ArrayList<>();

    public static void setDatabase(String databaseName){
        if(!dataSourceList.contains(databaseName)){
            logger.error("the datasource is not configuration");
        }else{
            database.set(databaseName);
        }

    }
    static String getDataBaseName(){

        return database.get();
    }

    public static void clearDatasourceHolder(){
        database.remove();
    }


}
