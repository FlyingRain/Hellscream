package com.flyingrain.translate.words.collection.api;

import com.flyingrain.translate.words.collection.result.SentenceDefine;
import com.flyingrain.translate.words.collection.result.WordResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by wally on 4/18/17.
 */
@Path("/words")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface WordQuery {

    @GET
    @Path("/query/word")
    WordResult queryWord(@QueryParam("word") String word, @QueryParam("type") int type);

    /**
     * 批量查询单词
     * @param wordIds
     * @return
     */
    List<WordResult> batchQueryWord(@QueryParam("wordIds") List<Integer> wordIds);

    @GET
    @Path("/query/sentence")
    SentenceDefine querySentence(@QueryParam("wordId") int wordId);

    @GET
    @Path("/query/singleWord")
    WordResult querySingleWord(@QueryParam("wordId") int wordId);
}
