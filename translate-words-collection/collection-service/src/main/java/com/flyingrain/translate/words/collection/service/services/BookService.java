package com.flyingrain.translate.words.collection.service.services;

import com.flyingrain.translate.words.collection.model.Book;

import java.util.List;

/**
 * Created by wally on 4/21/17.
 */
public interface BookService {

    List<Book> getAllBooks();

    Book getBookByType(int type);
}
