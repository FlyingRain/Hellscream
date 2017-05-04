package com.flyingrain.translate.plan.api.intf;

import com.flyingrain.translate.plan.api.response.Result;
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

    @Path("/getTask")
    @GET
    Result<Task> getUserPlanTask(@QueryParam("planId")Integer planId,@QueryParam("userId")Integer userId);

}
