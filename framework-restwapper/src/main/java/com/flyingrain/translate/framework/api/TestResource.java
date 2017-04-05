package com.flyingrain.translate.framework.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by wally on 4/1/17.
 */
@Path("/test")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TestResource {

    @Path("/wul")
    @GET
    String getTest();
}
