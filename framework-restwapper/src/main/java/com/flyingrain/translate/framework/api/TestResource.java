package com.flyingrain.translate.framework.api;

import com.flyingrain.translate.framework.api.param.MyParam;
import com.flyingrain.translate.framework.api.param.MyResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
    List<MyResult> testPost(MyParam a);
}
