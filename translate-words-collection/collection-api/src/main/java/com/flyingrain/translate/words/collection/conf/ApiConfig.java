package com.flyingrain.translate.words.collection.conf;

import com.flyingrain.translate.framework.wrapper.impl.RestWrapper;
import com.flyingrain.translate.words.collection.api.BookQuery;
import com.flyingrain.translate.words.collection.api.WordQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wally on 4/12/17.
 */
@Configuration
public class ApiConfig {

    @Bean
    BookQuery bookQuery(){
        return RestWrapper.wrapper(BookQuery.class);
    }

    @Bean
    WordQuery wordQuery(){
        return RestWrapper.wrapper(WordQuery.class);
    }
}
