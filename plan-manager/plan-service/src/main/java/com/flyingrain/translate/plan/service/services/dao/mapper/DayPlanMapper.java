package com.flyingrain.translate.plan.service.services.dao.mapper;

import com.flyingrain.translate.plan.service.services.dao.model.DayPlan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * Created by wally on 4/25/17.
 */
public interface DayPlanMapper {

    @Insert("insert into recite_day_plan (word_ids,is_complete,user_id,plan_date,complete_time,score,plan_id) values" +
            "(#{dayPlan.word_ids},#{dayPlan.is_complete},#{dayPlan.user_id},#{dayPlan.plan_date},#{dayPlan.complete_tome}," +
            "#{dayPlan.score},#{dayPlan.plan_id})")
    int insertDayPlan(@Param("dayPlan") DayPlan dayPlan);

    @Select("select word_ids,is_complete,user_id,plan_date,complete_time,score,plan_id from recite_day_plan where user_id=#{userId} and plan_date=#{planDate}")
    List<DayPlan> getDayPlan(@Param("userId") int userId, @Param("planDate")Date planDate);


}
