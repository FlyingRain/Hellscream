package com.flyingrain.translate.framework.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by wally on 4/1/17.
 */
@Path("/test")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TestResource {

    @Path("/wul/{paramTest}/pp")
    @GET
    String getTest(@PathParam("paramTest")String path,@QueryParam("query")String query);

    @Path("/post")
    @POST
    String testPost(String a);
}
