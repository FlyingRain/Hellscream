package com.flyingrain.translate.words.collection.api;

import com.flyingrain.translate.words.collection.model.Result;

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
    @Path("/start/collect/words")
    Result<String> collectWords(@QueryParam("fileName") String fileName, @QueryParam("type") int type);


    @GET
    @Path("/start/collect/sentence")
    Result<String> collectSentence();
}
