package com.flyingrain.translate.plan.api.intf;

import com.flyingrain.translate.plan.api.request.TaskResult;
import com.flyingrain.translate.plan.api.response.Task;
import com.flyingrain.translate.plan.api.response.TaskSummary;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;

/**
 * Created by wally on 5/4/17.
 */
@Path("/task")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface TaskResource {

    /**
     * 获取下一次任务
     * @param planId
     * @param userId
     * @return
     */
    @GET
    @Path("/getTask")
    Task getUserPlanTask(@QueryParam("planId")Integer planId, @QueryParam("userId")Integer userId, @QueryParam("planDate")String planDate);


    /**
     * 获取任务摘要
     * @param planId
     * @param userId
     * @param planDate
     * @return
     */
    @GET
    @Path("/getTaskSummary")
    TaskSummary getTaskSummary(@QueryParam("planId")Integer planId,@QueryParam("userId")Integer userId,@QueryParam("planDate")String planDate);
    /**
     * 生成用户的每日计划
     * @return 结果
     */
    @Path("/generate/dayPlan")
    String generate();

    /**
     * 同步任务完成情况
     * @param taskResult 任务完成情况
     * @return
     */
    @POST
    @Path("/synchronize/TaskResult")
    String synchronizeTaskResult(TaskResult taskResult);

}
