package com.flyingrain.translate.words.collection.service.resourceImpl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.words.collection.api.BookQuery;
import com.flyingrain.translate.words.collection.request.BookWords;
import com.flyingrain.translate.words.collection.result.Book;
import com.flyingrain.translate.words.collection.result.Result;
import com.flyingrain.translate.words.collection.result.ResultType;
import com.flyingrain.translate.words.collection.result.WordResult;
import com.flyingrain.translate.words.collection.service.dao.model.WordTypeRelations;
import com.flyingrain.translate.words.collection.service.services.BookService;
import com.flyingrain.translate.words.collection.service.services.WordServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
    public Result<List<Book>> getBookList() {
        List<Book> books = bookService.getAllBooks();
        Result<List<Book>> result = new Result<>();
        if(CollectionUtils.isEmpty(books)){
            logger.warn("there is no book in database!");
        }
        result.setCode(ResultType.SUCCESS.code);
        result.setMsg(ResultType.SUCCESS.desc);
        result.setRealResult(books);

        return result;
    }

    @Override
    public Result<Book> getBook(int type) {
        Book book = bookService.getBookByType(type);
        Result<Book> result = new Result<>();
        result.setMsg(ResultType.SUCCESS.desc);
        result.setCode(ResultType.SUCCESS.code);
        result.setRealResult(book);
        return result;
    }

    @Override
    public List<WordResult> getBookWords(BookWords bookWords) {
        List<WordTypeRelations> wordIds = bookService.getWordIds(bookWords.getBookId(),bookWords.getWordIds(),bookWords.getNumber());
        List<WordResult> wordResults = new ArrayList<>();
        wordServices.getWord()
        return null;
    }
}
