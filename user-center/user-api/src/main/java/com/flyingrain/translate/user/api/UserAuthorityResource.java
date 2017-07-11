package com.flyingrain.translate.user.api;

import com.flyingrain.translate.user.api.request.AuthRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by wally on 17-7-10.
 */
@Path("/authority")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UserAuthorityResource {



    @Path("/verifyAuthority")
    @POST
    boolean auth(AuthRequest request);
}
