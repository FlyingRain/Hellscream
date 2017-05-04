package com.flyingrain.translate.plan.service.services.dao.mapper;

import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.service.services.dao.model.PlanModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wally on 4/25/17.
 */
public interface PlanMapper {

    @Insert("insert into plan (user_id,plan_type,deadline,word_number,book_id,end_date,book_name) values " +
            "(#{plan.user_id},#{plan.plan_type},#{plan.deadline},#{plan.word_number},#{plan.book_id},#{plan.end_date},#{plan.book_name})")
    @Options(useGeneratedKeys = true,keyProperty = "plan.id")
    int insertPlan(@Param("plan")PlanModel plan);


    @Select("select id,user_id,plan_type,end_date,deadline,word_number,book_id,is_over,book_name from plan where user_id=#{userId}")
    List<Plan> getPlans(@Param("userId") int userId);

    @Select("select id,user_id,plan_type,end_date,deadline,word_number,book_id,is_over,book_name from plan where user_id=#{userId} and id=#{planId}")
    Plan getPlan(@Param("userId")int userId,@Param("planId")int planId);

}
