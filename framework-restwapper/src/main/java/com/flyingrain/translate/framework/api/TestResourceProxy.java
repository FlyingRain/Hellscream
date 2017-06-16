package com.flyingrain.translate.framework.api;

import com.flyingrain.translate.framework.api.param.MyParam;
import com.flyingrain.translate.framework.api.param.MyResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by wally on 6/10/17.
 */
@Path("/test")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TestResourceProxy {

    @GET
    @Path("/resource/proxy")
    MyResult testProxy();

    @POST
    @Path("/webtarget")
    MyResult testWebTarget(MyParam a);

    @GET
    @Path("/common")
    String testCommon();
}
