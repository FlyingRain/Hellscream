package com.flyingrain.translate.user.api;

import com.flyingrain.translate.user.api.request.LoginRequest;
import com.flyingrain.translate.user.api.response.UserInfo;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by wally on 6/29/17.
 */
@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface Login {

    @Path("/login")
    @POST
    String login(LoginRequest loginRequest);

    @Path("/userInfo")
    @POST
    UserInfo getUserInfo();




}
