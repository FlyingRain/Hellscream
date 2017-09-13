package com.flyingrain.translate.words.collection.service.services;

import com.flyingrain.translate.words.collection.request.BookWords;
import com.flyingrain.translate.words.collection.result.Book;
import com.flyingrain.translate.words.collection.result.WordResult;

import java.util.List;

/**
 * Created by wally on 4/21/17.
 */
public interface BookService {

    /**
     * 获取所有书本类型
     * @return
     */
    List<Book> getAllBooks();

    /**
     * 获取书本信息
     * @param type
     * @return
     */
    Book getBookByType(int type);

    /**
     * 根据书本名称获取书本信息
     * @param bookName
     * @return
     */
    List<Book> getBookByName(String bookName);


    List<WordResult> queryByCondition(BookWords bookWords);

}
