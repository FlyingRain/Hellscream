package com.flyingrain.translate.dungeon.api;

import com.flyingrain.translate.dungeon.api.domain.DungeonDomain;
import com.flyingrain.translate.dungeon.api.requests.DungeonQueryRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 副本管理
 * Created by wally on 17-8-15.
 */
@Path("/dungeonManager")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface DungeonManagerResources {

    /**
     * 添加副本模型
     * @param dungeonDomain
     * @return
     */
    @POST
    @Path("/addDungeon")
    int addDungeonModule(DungeonDomain dungeonDomain);


    /**
     * 删除副本
     * @param dungeonId
     * @return
     */
    @GET
    @Path("/deleteDungeon")
    int deleteDungeon(@QueryParam("dungeonId") Integer dungeonId);


    /**
     * 副本分页查询
     * @param queryRequest
     * @return
     */
    @POST
    @Path("/pageQuery/dungeon")
    List<DungeonDomain> pageQuery(DungeonQueryRequest queryRequest);

}
