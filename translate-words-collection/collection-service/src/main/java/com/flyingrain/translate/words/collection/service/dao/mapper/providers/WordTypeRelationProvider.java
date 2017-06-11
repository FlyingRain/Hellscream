package com.flyingrain.translate.words.collection.service.dao.mapper.providers;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by wally on 6/10/17.
 */
public class WordTypeRelationProvider {

    private Logger logger = LoggerFactory.getLogger(WordTypeRelationProvider.class);

    /**
     * 获取单词Id sql
     *
     * @param params
     * @return
     */
    public String getWordIdsSql(Map params) {

        List<Integer> wordIds = (List<Integer>) params.get("wordIds");

        StringBuilder sql = new StringBuilder("select word_id,type_code from word_type_relations ");
        sql.append("where type_code = #{type} ");
        if (CollectionUtils.isNotEmpty(wordIds)) {
            sql.append(" and word_id not in (");

            for (int i = 0; i < wordIds.size(); i++) {
                sql.append("#{wordIds[").append(i).append("]}");
                if (i < wordIds.size() - 1)
                    sql.append(",");
            }
            sql.append(")");
//            sql.append(wordIds.stream().map(Object::toString).reduce((i, o) -> i + "," + o)).append(")");
        }

        sql.append(" limit #{number}");

        logger.info("get real Sql : [{}]", sql);
        return sql.toString();
    }

}
