package com.flyingrain.translate.words.collection.service.dao.mapper.providers;

import com.flyingrain.translate.words.collection.model.BookType;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by wally on 9/12/17.
 */
public class WordProvider {

    private Logger logger = LoggerFactory.getLogger(WordProvider.class);
    /**
     * 获取sql
     *
     * @param params
     * @return
     */
    public String queryExcept(Map params) {

        List<Integer> wordIds = (List<Integer>) params.get("wordIds");
        int type = (Integer) params.get("type");

        StringBuilder sql = new StringBuilder("select * from words w");
        if (type == BookType.BASIC.type) {
            sql.append(" where w.id not in (select word_id from word_type_relations) ");
            if(CollectionUtils.isNotEmpty(wordIds)){
                sql.append(" and ");
            }
        } else {
            sql.append(" join word_type_relations wtr on wtr.word_id=w.id and wtr.type_code=#{type} ");
            if(CollectionUtils.isNotEmpty(wordIds)){
                sql.append(" where ");
            }
        }

        if (CollectionUtils.isNotEmpty(wordIds)) {
            sql.append("  w.id not in (");
            for (int i = 0; i < wordIds.size(); i++) {
                sql.append("#{wordIds[").append(i).append("]}");
                if (i < wordIds.size() - 1)
                    sql.append(",");
            }
            sql.append(")");
        }
        logger.info("get sql :[{}]",sql.toString());
        return sql.toString();
    }
}
