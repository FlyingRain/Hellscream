package com.flyingrain.translate.user.service.services.dao.mapper;

import com.flyingrain.translate.user.service.services.dao.model.AuthorityModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wally on 7/14/17.
 */
public interface AuthorityMapper {

    @Insert("insert into authority (authority_name,url,desc) values (#{authorityModel.authority_name},#{authorityModel.url},#{authorityModel.desc})")
    @Options(useGeneratedKeys = true,keyProperty = "authorityModel.id")
    int insertAuthority(@Param("authorityModel") AuthorityModel authorityModel);


    @Select("select * from authority")
    List<AuthorityModel> getAllAuthority();


}
