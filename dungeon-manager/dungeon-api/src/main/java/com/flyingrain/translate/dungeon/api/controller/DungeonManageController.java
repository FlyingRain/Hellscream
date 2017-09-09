package com.flyingrain.translate.dungeon.api.controller;

import com.flyingrain.translate.dungeon.api.domain.DungeonConsist;
import com.flyingrain.translate.dungeon.api.domain.DungeonRelation;
import com.flyingrain.translate.dungeon.api.domain.DungeonResource;
import com.flyingrain.translate.dungeon.api.domain.DungeonRole;
import com.flyingrain.translate.dungeon.api.service.DungeonConsistService;
import com.flyingrain.translate.dungeon.api.service.DungeonRelationService;
import com.flyingrain.translate.dungeon.api.service.DungeonResourceService;
import com.flyingrain.translate.dungeon.api.service.DungeonRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Uni on 2017/9/9.
 */
@Path("/dungeon")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DungeonManageController {

    @Autowired
    private DungeonRoleService dungeonRoleService;
    @Autowired
    private DungeonResourceService dungeonResourceService;
    @Autowired
    private DungeonRelationService dungeonRelationService;
    @Autowired
    private DungeonConsistService dungeonConsistService;

    @Path("/listDungeon")
    @GET
    List<DungeonConsist> list(@QueryParam("page") int page) {
        List<DungeonConsist> list = new ArrayList<DungeonConsist>();
        List<DungeonRelation> list1 = dungeonRelationService.getList(page);
        for(int i = 0; i< list1.size(); i++) {
            DungeonResource dungeonResource = dungeonResourceService.getResource(list1.get(i).getDungeon_id());
            DungeonRole dungeonRole = dungeonRoleService.getRole(list1.get(i).getRole_id());
            DungeonConsist dungeonConsist = dungeonConsistService.getDungeonConsist(dungeonResource, dungeonRole);
            list.add(dungeonConsist);
        }
        return list;
    }
}
