package com.flyingrain.translate.words.collection.api;

import com.flyingrain.translate.words.collection.model.Result;
import com.flyingrain.translate.words.collection.model.SentenceDefine;
import com.flyingrain.translate.words.collection.model.WordResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by wally on 4/18/17.
 */
@Path("/words")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface WordQuery {

    @GET
    @Path("/query/word")
    Result<WordResult> queryWord(@QueryParam("word") String word,@QueryParam("type") int type);


    @GET
    @Path("/query/sentence")
    Result<SentenceDefine> querySentence(@QueryParam("wordId") int wordId);
}
