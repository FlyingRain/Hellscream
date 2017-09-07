package com.flyingrain.translate.dungeon.api;

import com.flyingrain.translate.dungeon.api.domain.DungeonDomain;

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


    List<DungeonDomain>

}
