package com.flyingrain.translate.words.collection.api;

import com.flyingrain.translate.words.collection.model.Book;
import com.flyingrain.translate.words.collection.model.Result;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by wally on 4/21/17.
 */
@Path("/book")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface BookQuery {

    @GET
    @Path("/books")
    Result<List<Book>> getBookList();

    @GET
    @Path("/query/book")
    Result<Book> getBook(@QueryParam("bookType") int type);


}
