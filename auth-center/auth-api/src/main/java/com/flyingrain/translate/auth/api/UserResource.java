package com.flyingrain.translate.auth.api;

import com.flyingrain.translate.auth.api.requests.VerifyRequest;
import com.flyingrain.translate.auth.api.responses.LoginResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by wally on 17-7-20.
 */
@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UserResource {

    /**
     * 用户登陆
     * @param request
     * @return
     */
    @POST
    @Path("/login")
    LoginResponse login(VerifyRequest request);







}
