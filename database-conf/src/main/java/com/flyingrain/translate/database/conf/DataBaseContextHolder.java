package com.flyingrain.translate.database.conf;

/**
 * 数据源线程容器
 * Created by wally on 4/7/17.
 */
public class DataBaseContextHolder {

    private static final ThreadLocal<String> database = new ThreadLocal<>();

    public static void setDatabase(String databaseName){
        database.set(databaseName);
    }
    public static String getDataBaseName(){
        return database.get();
    }
}
