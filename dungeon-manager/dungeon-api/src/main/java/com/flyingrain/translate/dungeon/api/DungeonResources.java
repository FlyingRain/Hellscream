package com.flyingrain.translate.dungeon.api;

import com.flyingrain.translate.dungeon.api.domain.DungeonInstance;
import com.flyingrain.translate.dungeon.api.requests.DungeonQueryRequest;
import com.flyingrain.translate.dungeon.api.requests.JoinRequest;
import com.flyingrain.translate.dungeon.api.responses.JoinResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by wally on 17-8-15.
 */
@Path("/dungeon")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface DungeonResources {

    /**
     * 根据条件查询副本实例
     *
     * @param queryRequest
     * @return
     */
    @POST
    @Path("/getDungeons")
    List<DungeonInstance> getDungeons(DungeonQueryRequest queryRequest);

    /**
     * 加入副本
     * @param joinRequest
     * @return
     */
    @POST
    @Path("/join")
    JoinResult joinDungeon(JoinRequest joinRequest);



}
