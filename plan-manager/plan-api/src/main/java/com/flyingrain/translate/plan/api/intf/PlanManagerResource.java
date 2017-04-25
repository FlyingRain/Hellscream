package com.flyingrain.translate.plan.api.intf;

import com.flyingrain.translate.plan.api.request.PlanRequest;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.Result;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by wally on 4/25/17.
 */
@Path("/plan")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PlanManagerResource {

    @POST
    @Path("/make")
    Result<Integer> makePlan(PlanRequest planRequest);

    @GET
    @Path("/query")
    Result<List<Plan>> queryPlan(@QueryParam("planId") int planId);
}
