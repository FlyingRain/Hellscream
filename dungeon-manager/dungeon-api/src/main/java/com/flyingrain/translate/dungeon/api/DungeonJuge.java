package com.flyingrain.translate.dungeon.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 副本定时任务
 * Created by wally on 10/26/17.
 */
@Path("dungeonJuge")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface DungeonJuge {

    /**
     * 开启副本
     * @return
     */
    @GET
    @Path("/startDungeon")
    String startDungeon();


    /**
     * 审判未完成计划的成员
     * @return
     */
    @GET
    @Path("/juge")
    String jugeMemebers();




}
