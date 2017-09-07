package com.flyingrain.translate.framework.lang.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具
 * Created by wally on 5/11/17.
 */
public class DateUtil {

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);


    /**
     * 对日期进行以天为单位的操作
     * @param date
     * @param day
     * @return
     */
    public static Date addDay(Date date,int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,day);
        return calendar.getTime();
    }

    /**
     * 获取当天凌晨的日期
     * @return
     */
    public static Date getTodayZeroDay(){
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),0,0,0);
        return calendar.getTime();
    }


    /**
     * 获取指定日期的凌晨时间
     * @param date
     * @return
     */
    public static Date getDateZeroDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),0,0,0);
        return calendar.getTime();
    }
}
