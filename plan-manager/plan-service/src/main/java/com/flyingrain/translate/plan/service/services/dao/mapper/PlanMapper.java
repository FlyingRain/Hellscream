package com.flyingrain.translate.plan.service.services.dao.mapper;

import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.service.services.dao.model.PlanModel;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by wally on 4/25/17.
 */
public interface PlanMapper {

    @Insert("insert into plan (user_id,plan_type,deadline,word_number,all_word_number,book_id,end_date,status) values " +
            "(#{plan.user_id},#{plan.plan_type},#{plan.deadline},#{plan.word_number},#{plan.all_word_number},#{plan.book_id},#{plan.end_date},#{plan.status})")
    @Options(useGeneratedKeys = true,keyProperty = "plan.id")
    Integer insertPlan(@Param("plan")PlanModel plan);

    /**
     * 获取用户的所有计划
     * @param userId
     * @return
     */
    @Select("select id,user_id,plan_type,end_date,all_word_number,deadline,word_number,book_id,status from plan where user_id=#{userId}")
    List<PlanModel> getPlans(@Param("userId") int userId);


    /**
     * 根据状态获取用户计划
     * @param userId
     * @param status
     * @return
     */
    @Select("select id,user_id,plan_type,end_date,deadline,word_number,book_id,status from plan where user_id=#{userId} and status=#{status}")
    List<PlanModel> getUserPlanByStatus(@Param("userId")int userId,@Param("status") int status);
    /**
     * 查询计划
     * @param planId
     * @return
     */
    @Select("select id,user_id,plan_type,end_date,deadline,word_number,book_id,status from plan where  id=#{planId}")
    PlanModel getPlan(@Param("planId")int planId);


    @Update("update plan set plan_type=#{plan.plan_type},all_word_number=#{plan.all_word_number},deadline=#{plan.deadline},book_id=#{plan.book_id},word_number=#{plan.word_number},status=#{plan.status} where id=#{plan.id}")
    int updatePlan(@Param("plan")PlanModel planModel);

    @Update("update plan set end_date=#{endDate},status=#{status} where id=#{planId}")
    int setEndDate(@Param("endDate")Date endDate,@Param("planId") int id,@Param("status") int status);

    @Update("update plan set status=#{status} where id=#{planId}")
    int updatePlanStatus(@Param("status")int status,@Param("planId")int id);
}
