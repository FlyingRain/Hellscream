package com.flyingrain.translate.words.collection.service.services;

import com.flyingrain.translate.words.collection.result.Book;
import com.flyingrain.translate.words.collection.service.dao.model.WordTypeRelations;

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
     * 获取除了列表以外的指定书本的指定单词个数
     * @param type 书本类型
     * @param wordIds 排除的单词ID
     * @param number 获取的单词个数
     * @return
     */
    List<WordTypeRelations> getWordIds(int type, List<Integer> wordIds, int number);
}
