package com.flyingrain.translate.user.service.services.dao.mapper;

import com.flyingrain.translate.user.service.services.dao.model.UserRoleRelationModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wally on 8/7/17.
 */
public interface UserRoleRelationMapper {

    /**
     * 插入一条用户角色
     * @param model
     * @return
     */
    @Insert("insert into user_role_relation (user_id,role_id,is_active) values (#{model.user_Id},#{model.role_id},#{model.is_active})")
    int insertUserRoleRelation(@Param("model") UserRoleRelationModel model);


    /**
     * 根据用户查询其角色
     * @param userId
     * @return
     */
    @Select("select role_id,is_active from user_role_relation where user_id=#{userId}")
    int getRoleId(String userId);

}
