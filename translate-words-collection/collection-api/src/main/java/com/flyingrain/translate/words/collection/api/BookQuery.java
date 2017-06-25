package com.flyingrain.translate.words.collection.api;

import com.flyingrain.translate.words.collection.request.BookWords;
import com.flyingrain.translate.words.collection.result.Book;
import com.flyingrain.translate.words.collection.result.WordResult;

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
    List<Book> getBookList();

    @GET
    @Path("/query/book")
    Book getBook(@QueryParam("bookType") int type);

    /**
     * 根据名称模糊查询
     * @param bookName
     * @return
     */
    @GET
    @Path("/query/bookByName")
    List<Book> getBooksByName(@QueryParam("bookName") String bookName);

    @POST
    @Path("/query/bookWords")
    List<WordResult> getBookWords(BookWords bookWords);


}
