package com.flyingrain.translate.plan.service.services.dao.mapper.providers;

import com.flyingrain.translate.plan.service.services.dao.model.UserWordRelation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by wul on 5/6/17.
 */
public class UserWordRelationProvider {

    private Logger logger = LoggerFactory.getLogger(UserWordRelationProvider.class);

    /**
     * 提供批量插入sql组装
     *
     * @param param
     * @return
     */
    public String batchInsert(Map param) {

        List<UserWordRelation> userWordRelations = (List<UserWordRelation>) param.get("userWordRelations");
        StringBuilder sqlBuilder = new StringBuilder("insert into user_word_relation (user_id,plan_id,word_id,proficiency) values ");

        MessageFormat messageFormat = new MessageFormat("#{userWordRelations[{0}].user_id},#{userWordRelations[{0}].plan_id},#{userWordRelations[{0}].word_id}" +
                ",#{userWordRelations[{0}].proficiency}");

        for (int i = 0; i < userWordRelations.size(); i++) {
            String format = messageFormat.format(new Object[]{i});
            sqlBuilder.append("(").append(format).append("),");
        }
        String sql = sqlBuilder.substring(0,sqlBuilder.length()-1);
        logger.info("get sql : [{}]",sql);
        return sql;
    }
}
