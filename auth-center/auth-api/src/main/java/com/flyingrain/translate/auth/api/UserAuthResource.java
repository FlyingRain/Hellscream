package com.flyingrain.translate.auth.api;

import com.flyingrain.translate.auth.api.requests.VerifyRequest;
import com.flyingrain.translate.auth.api.responses.LoginResponse;
import com.flyingrain.translate.auth.api.responses.RegisterResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by wally on 17-7-20.
 */
@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UserAuthResource {

    /**
     * 用户登陆
     * @param request
     * @return
     */
    @POST
    @Path("/login")
    LoginResponse login(VerifyRequest request);


    @POST
    @Path("/wxLogin")
    LoginResponse wxLogin(VerifyRequest verifyRequest);

    @POST
    @Path("/wxBind")
    boolean wxBind(VerifyRequest verifyRequest);

    /**
     * 用户注册
     * @param request
     * @return
     */
    @POST
    @Path("/register")
    RegisterResponse register(VerifyRequest request);


    /**
     * logoff
     * @param userId
     * @return userId
     */
    @GET
    @Path("/logoff")
    String logoff(@QueryParam("userId") String userId);

}
