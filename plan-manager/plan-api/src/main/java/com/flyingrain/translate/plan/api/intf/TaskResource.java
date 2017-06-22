package com.flyingrain.translate.plan.api.intf;

import com.flyingrain.translate.plan.api.request.TaskResult;
import com.flyingrain.translate.plan.api.response.Task;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
     * 同步任务完成情况
     * @param taskResult 任务完成情况
     * @return
     */
    @POST
    @Path("/synchronize/TaskResult")
    String synchronizeTaskResult(TaskResult taskResult);

}
