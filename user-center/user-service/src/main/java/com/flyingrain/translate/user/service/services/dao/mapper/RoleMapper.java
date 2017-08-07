package com.flyingrain.translate.user.service.services.dao.mapper;

import com.flyingrain.translate.user.service.services.dao.model.RoleModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wally on 17-7-13.
 */
public interface RoleMapper {

    @Insert("insert into role values (role,desc) values (#{model.role},#{model.desc})")
    @Options(useGeneratedKeys = true,keyProperty = "model.id")
    int insertRole(@Param("model") RoleModel model);


    /**
     * 获取所有角色信息
     * @return
     */
    @Select("select id,role,desc,data_added,last_modified from role")
    List<RoleModel> getAllRoles();


    /**
     * 获取角色Id
     * @param role
     * @return
     */
    @Select("select id from role where role=#{role}")
    int getRoleId(String role);
}
