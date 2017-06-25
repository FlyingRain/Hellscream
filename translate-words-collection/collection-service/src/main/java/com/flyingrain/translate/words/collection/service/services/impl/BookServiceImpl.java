package com.flyingrain.translate.words.collection.service.services.impl;

import com.flyingrain.translate.words.collection.result.Book;
import com.flyingrain.translate.words.collection.model.BookType;
import com.flyingrain.translate.words.collection.service.dao.mapper.WordMapper;
import com.flyingrain.translate.words.collection.service.dao.mapper.WordTypeMapper;
import com.flyingrain.translate.words.collection.service.dao.mapper.WordTypeRelationsMapper;
import com.flyingrain.translate.words.collection.service.dao.model.WordType;
import com.flyingrain.translate.words.collection.service.dao.model.WordTypeRelations;
import com.flyingrain.translate.words.collection.service.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wally on 4/21/17.
 */
@Component
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private WordTypeMapper wordTypeMapper;
    @Autowired
    private WordTypeRelationsMapper wordTypeRelationsMapper;
    @Autowired
    private WordMapper wordMapper;

    @Override
    public List<Book> getAllBooks() {
        List<WordType> wordTypes = wordTypeMapper.getWordTypes();
        List<Book> books = new ArrayList<>();
        if (CollectionUtils.isEmpty(wordTypes)) {
            logger.warn("no book in database!");
            return null;
        }
        wordTypes.forEach(wordType -> {
            Book book = new Book();
            book.setName(wordType.getType_name());
            book.setId(wordType.getId());
            book.setType(wordType.getType_code());
            logger.info("get book [{}]", book);
            Integer number;
            if (BookType.BASIC.type == wordType.getType_code()) {
                logger.info("will get basic book'number!");
                number = getBasicNumber();
            } else
                number = wordTypeRelationsMapper.getTypeNumber(wordType.getType_code());
            logger.info("get book wordNumber [{}]", number);
            book.setWordNumber(number==null?0:number);
            books.add(book);
        });
        return books;
    }

    @Override
    public Book getBookByType(int type) {
        WordType wordType = wordTypeMapper.getWordType(type);
        if(wordType==null){
            return null;
        }
        Book book = new Book();
        book.setName(wordType.getType_name());
        book.setType(type);
        book.setId(wordType.getId());
        logger.info("get book [{}]",book);
        if(type==BookType.BASIC.type){
            book.setWordNumber(getBasicNumber());
        }else{
            Integer number = wordTypeRelationsMapper.getTypeNumber(type);
            book.setWordNumber(number==null?0:number);
        }
        logger.info("return book :[{}]",book);
        return book;
    }

    @Override
    public List<Book> getBookByName(String bookName) {
        if(bookName==null){
            bookName="";
        }
        logger.info("start to search bookName:[{}]",bookName);
        List<WordType> wordTypes = wordTypeMapper.getWordTypesByName(bookName);
        return wordTypes.stream().map(wordType -> getBookByType(wordType.getType_code())).collect(Collectors.toList());
    }

    @Override
    public List<WordTypeRelations> getWordIds(int type, List<Integer> wordIds, int number) {
        return wordTypeRelationsMapper.getWordIds(type,wordIds,number);
    }

    private int getBasicNumber() {
        Integer allWords = wordMapper.getAllWords();
        Integer allWordsInBooks = wordTypeRelationsMapper.getAllWords();
        allWords = allWords==null?0:allWords;
        allWordsInBooks= allWordsInBooks==null?0:allWordsInBooks;
        if (allWordsInBooks > allWords) {
            logger.error("wrong word number! word's number in words is [{}],but in relations is [{}]", allWords, allWordsInBooks);
            return 0;
        }
        return (allWords - allWordsInBooks);
    }
}
