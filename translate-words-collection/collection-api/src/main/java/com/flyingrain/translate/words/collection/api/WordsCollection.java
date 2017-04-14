package com.flyingrain.translate.words.collection.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by wally on 4/6/17.
 */
@Path("/words")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface WordsCollection {

    @GET
    @Path("/start/collect")
    String collectWords(@QueryParam("fileName") String fileName,@QueryParam("type")int type) ;




}
