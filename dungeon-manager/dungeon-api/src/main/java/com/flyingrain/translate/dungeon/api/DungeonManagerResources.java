package com.flyingrain.translate.dungeon.api;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by wally on 17-8-15.
 */
@Path("/dungeonManager")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface DungeonManagerResources {

    @POST
    @Path("/addDungeon")
    int addDungeon();


}
