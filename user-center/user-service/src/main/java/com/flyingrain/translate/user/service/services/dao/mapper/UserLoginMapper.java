package com.flyingrain.translate.user.service.services.dao.mapper;

import com.flyingrain.translate.user.service.services.dao.model.UserLoginModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wally on 7/10/17.
 */
public interface UserLoginMapper {

    @Insert("insert into user_login (user_id,password) values (#{userLoginModel.user_id},#{userLoginModel.password})")
    @Options(useGeneratedKeys = true,keyProperty = "userLoginModel.id")
    int insertUserLogin(@Param("userLoginModel")UserLoginModel userLoginModel);

    @Select("select * from user_login where user_id=#{userLoginModel.user_id} and password=#{userLoginModel.password}")
    String authentity(@Param("userLoginModel") UserLoginModel model);

}
