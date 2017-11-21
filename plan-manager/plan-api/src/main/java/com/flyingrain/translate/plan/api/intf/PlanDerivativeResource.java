package com.flyingrain.translate.plan.api.intf;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by wally on 11/21/17.
 */
@Path("/plan")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PlanDerivativeResource {

    @GET
    @Path("/leftDay")
    int getPlanLeftDay(@QueryParam("planId") Integer planId);

}
