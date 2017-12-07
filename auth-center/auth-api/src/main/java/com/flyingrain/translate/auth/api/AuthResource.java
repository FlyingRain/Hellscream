package com.flyingrain.translate.auth.api;

import com.flyingrain.translate.auth.api.requests.AuthRequest;
import com.flyingrain.translate.auth.api.responses.AuthResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 鉴权
 * Created by wally on 7/26/17.
 */
@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface AuthResource {


    /**
     * 用户鉴权
     * @param request
     * @return
     */
    @POST
    @Path("/userAuth")
    AuthResponse authority(AuthRequest request);


}
