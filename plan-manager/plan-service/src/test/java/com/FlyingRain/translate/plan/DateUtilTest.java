package com.FlyingRain.translate.plan;


import com.flyingrain.translate.plan.service.services.utils.DateUtil;
import org.junit.Test;

import java.util.Date;

/**
 * Created by wally on 5/11/17.
 */
public class DateUtilTest {

    @Test
    public void testUtil(){
        Date date =  DateUtil.getTodayZeroDay();

        System.out.println(date);
    }
}
