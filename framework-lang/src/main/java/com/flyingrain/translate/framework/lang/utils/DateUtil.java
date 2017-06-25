package com.flyingrain.translate.framework.lang.utils;

import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.framework.lang.common.FrameworkExceptionCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具
 * Created by wally on 5/11/17.
 */
public class DateUtil {

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    private static SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy/MM/dd");

    /**
     * 默认格式化：yyyy/MM/dd
     * @param date
     * @return
     */
    public static Date formatDateDefault(String date){
        if(StringUtils.isEmpty(date)){
            logger.info("format date is null!");
            return null;
        }
        try {
            return defaultFormat.parse(date);
        } catch (ParseException e) {
            logger.error("date format exception ",e);
            throw new FlyException(FrameworkExceptionCode.DATEFORMATERROR.getCode(),FrameworkExceptionCode.DATEFORMATERROR.getMsg());
        }
    }

    public static Date formatDate(String date,String dateFormat){
        if(StringUtils.isEmpty(date)){
            logger.info("format date is null!");
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            logger.error("format date exception!",e);
            throw  new FlyException(FrameworkExceptionCode.DATEFORMATERROR.getCode(),FrameworkExceptionCode.DATEFORMATERROR.getMsg());

        }
    }


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
