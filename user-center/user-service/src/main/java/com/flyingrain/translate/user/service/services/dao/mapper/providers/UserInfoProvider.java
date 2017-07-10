package com.flyingrain.translate.user.service.services.dao.mapper.providers;

import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.user.service.services.common.UserCenterExceptionEnum;
import com.flyingrain.translate.user.service.services.dao.model.UserInfoModel;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by wally on 7/10/17.
 */
public class UserInfoProvider {

    private Logger logger = LoggerFactory.getLogger(UserInfoProvider.class);

    /**
     * 获取用户Id sql
     * @param param
     * @return
     */
    public String getUserId(Map param){
        UserInfoModel model = (UserInfoModel) param.get("userInfoModel");
        StringBuilder sql = new StringBuilder("select id from user_info where ");
        if(StringUtils.isNotEmpty(model.getPet_name())){
            sql.append(" pet_name=#{userInfoModel.pet_name} and ");
        }
        if(StringUtils.isNotEmpty(model.getEmail())){
            sql.append(" email=#{userInfoModel.email} and ");
        }
        if(StringUtils.isNotEmpty(model.getPhone())){
            sql.append(" phone=#{userInfoModel.phone} and");
        }
        if(sql.toString().contains("and")){
            String sqlString = sql.substring(0,sql.indexOf("and"));
            logger.info("sql is [{}]",sqlString);
            return sqlString;
        }else{
            throw new FlyException(UserCenterExceptionEnum.ParamError.getCode(),UserCenterExceptionEnum.ParamError.getMsg());
        }
    }
}
