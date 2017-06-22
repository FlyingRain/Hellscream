package com.flyingrain.translate.plan.service.services.dao.mapper;

import com.flyingrain.translate.plan.service.services.dao.model.DayPlan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * Created by wally on 4/25/17.
 */
public interface DayPlanMapper {

    @Insert("insert into recite_day_plan (word_ids,status,user_id,plan_date,complete_time,score,plan_id) values" +
            "(#{dayPlan.word_ids},#{dayPlan.status},#{dayPlan.user_id},#{dayPlan.plan_date},#{dayPlan.complete_time}," +
            "#{dayPlan.score},#{dayPlan.plan_id})")
    int insertDayPlan(@Param("dayPlan") DayPlan dayPlan);

    @Select("select word_ids,status,user_id,plan_date,complete_time,score,plan_id from recite_day_plan where user_id=#{userId} and plan_date>#{planStartDate} and plan_date<#{planEndDate}")
    DayPlan getDayPlan(@Param("userId") int userId, @Param("planStartDate")Date planStartDate ,@Param("planEndDate") Date planEndDate);

    /**
     * 根据Id获取计划信息
     * @param taskId
     * @return
     */
    @Select("select word_ids,status,user_id,plan_date,complete_time,score,plan_id from recite_day_plan where id=#{taskId}")
    DayPlan getDayPlanById(@Param("taskId")int taskId);
    /**
     * 获取用户最近一次计划的情况
     * @param userId
     * @param planId
     * @return
     */
    @Select("select id,status,user_id,plan_id,last_modified from recite_day_plan a where EXISTS (select 1 from (select user_id,plan_id,MAX(last_modified) as last_modified from recite_day_plan group by user_id,plan_id HAVING user_id=#{userId} and plan_id=#{planId} ) b where a.user_id=b.user_id and a.plan_id=b.plan_id and a.last_modified=b.last_modified)")
    DayPlan getUserLatestTask(@Param("userId")int userId, @Param("planId") int planId);

    /**
     * 根据日期和状态查询所有用户
     * @return
     */
    @Select("select id,user_id,plan_id from recite_day_plan  where status=#{status} and last_modified>#{startDate} and last_modified<#{endDate}")
    List<DayPlan> getLatestDayPlans(@Param("status") int status,@Param("date")Date startDate,@Param("endDate")Date endDate);

    @Update("update recite_day_plan set status=#{status} where id=#{taskId}")
    int updateTaskStatus(@Param("status")int status,@Param("taskId") int taskId);
}
