package com.flyingrain.translate.words.collection.service.resourceImpl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.words.collection.api.BookQuery;
import com.flyingrain.translate.words.collection.request.BookWords;
import com.flyingrain.translate.words.collection.result.Book;
import com.flyingrain.translate.words.collection.result.WordResult;
import com.flyingrain.translate.words.collection.service.services.BookService;
import com.flyingrain.translate.words.collection.service.services.WordServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by wally on 4/21/17.
 */
@Component
@Resource
public class BookQueryImpl implements BookQuery{

    private Logger logger = LoggerFactory.getLogger(BookQueryImpl.class);

    @Autowired
    private BookService bookService;
    @Autowired
    private WordServices wordServices;

    @Override
    public List<Book> getBookList() {
        List<Book> books = bookService.getAllBooks();
        if(CollectionUtils.isEmpty(books)){
            logger.warn("there is no book in database!");
        }
        return books;
    }

    @Override
    public Book getBook(int type) {
        return bookService.getBookByType(type);
    }

    @Override
    public List<Book> getBooksByName(String bookName) {
        return bookService.getBookByName(bookName);
    }

    @Override
    public List<WordResult> getBookWords(BookWords bookWords) {
        return bookService.queryByCondition(bookWords);
    }
}
