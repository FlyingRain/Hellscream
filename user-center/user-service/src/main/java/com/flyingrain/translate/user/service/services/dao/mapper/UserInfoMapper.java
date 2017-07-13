package com.flyingrain.translate.user.service.services.dao.mapper;

import com.flyingrain.translate.user.service.services.dao.mapper.providers.UserInfoProvider;
import com.flyingrain.translate.user.service.services.dao.model.UserInfoModel;
import org.apache.ibatis.annotations.*;

/**
 * Created by wally on 7/5/17.
 */
public interface UserInfoMapper {


    @Insert("insert into user_info (name,pet_name,school,phone,verify_phone,email,verify_email,age) values " +
            "(#{userInfo.name},#{userInfo.pet_name},#{userInfo.school},#{userInfo.phone},#{userInfo.verify_phone},#{userInfo.email},#{userInfo.verify_email},#{userInfo.age})")
    @Options(useGeneratedKeys = true,keyProperty = "userInfo.id")
    int insertUserInfo(@Param("userInfo") UserInfoModel model);


    /**
     * 根据用户Id获取用户信息
     * @param userId
     * @return
     */
    @Select("select * from user_info where user_id=#{userId}")
    UserInfoModel getUserInfoById(int userId);


    /**
     * 通过用户信息获取用户Id
     * @param model
     * @return
     */
    @SelectProvider(type = UserInfoProvider.class,method = "getUserId")
    int getUserId(@Param("userInfoModel")UserInfoModel model);

}
