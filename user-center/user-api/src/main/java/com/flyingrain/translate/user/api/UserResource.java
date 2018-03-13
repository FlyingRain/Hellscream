package com.flyingrain.translate.user.api;

import com.flyingrain.translate.user.api.request.LoginRequest;
import com.flyingrain.translate.user.api.request.UserInfo;
import com.flyingrain.translate.user.api.request.WxBindRequest;
import com.flyingrain.translate.user.api.request.WxLoginRequest;
import com.flyingrain.translate.user.api.response.LoginResult;
import com.flyingrain.translate.user.api.response.UserInfoResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by wally on 6/29/17.
 */
@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UserResource {

    @Path("/addUser")
    @POST
    String addUser(UserInfo userInfo);


    @Path("/userInfo")
    @GET
    UserInfoResult getUserInfo(@QueryParam("userId")int userId);


    @Path("/user/login")
    @POST
    LoginResult login(LoginRequest loginRequest);


    @Path("/user/wxLogin")
    @POST
    LoginResult wxLogin(WxLoginRequest wxLoginRequest);


    @Path("/user/wxBind")
    @POST
    boolean bindWx(WxBindRequest wxBindRequest);

}
