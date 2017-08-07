package com.flyingrain.translate.user.service.services.dao.mapper;

import com.flyingrain.translate.user.service.services.dao.model.RoleAuthorityModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wally on 8/7/17.
 */
public interface RoleAuthorityMapper {

    /**
     * 插入一条角色权限
     * @param model
     * @return
     */
    @Insert("insert into role_authority (role_id,authority_id,is_active) values (#{model.role_id},#{model.authority_id},#{model.is_active})")
    int insertRoleAuthorityRelation(RoleAuthorityModel model);


    /**
     * 查询角色所有权限
     * @param roleId
     * @return
     */
    @Select("select id,role_id,authority_id,is_active from role_authority where role_id=#{roleId}")
    List<RoleAuthorityModel> getAuthorityModel(String roleId);


    /**
     * 查询用户特定权限
     * @param userId
     * @param url
     * @return
     */
    @Select("select ra.role_id,ra.authority_id,ra.is_active from role_authority ra  join user_role_relation  urr on (ra.role_id=urr.role_id and urr.user_id=#{userId})  join authority a on (ra.authority_id=a.id and url=#{url})")
    RoleAuthorityModel getAuthority(@Param("userId") int userId, @Param("url") String url);
}
