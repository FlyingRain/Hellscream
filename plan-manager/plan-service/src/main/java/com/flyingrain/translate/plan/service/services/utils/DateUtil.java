package com.flyingrain.translate.plan.service.services.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by wally on 5/11/17.
 */
public class DateUtil {
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

}