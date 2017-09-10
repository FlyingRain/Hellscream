package com.flyingrain.translate.dungeon.api.controller;

import com.flyingrain.translate.dungeon.api.domain.DungeonConsist;
import com.flyingrain.translate.dungeon.api.domain.DungeonRelation;
import com.flyingrain.translate.dungeon.api.domain.DungeonResource;
import com.flyingrain.translate.dungeon.api.domain.DungeonRole;
import com.flyingrain.translate.dungeon.api.service.DungeonConsistService;
import com.flyingrain.translate.dungeon.api.service.DungeonRelationService;
import com.flyingrain.translate.dungeon.api.service.DungeonResourceService;
import com.flyingrain.translate.dungeon.api.service.DungeonRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Uni on 2017/9/9.
 */
@Component
@Path("/dungeon")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DungeonManageController {

    private Logger logger = LoggerFactory.getLogger(DungeonManageController.class);
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
    public Map<String, Object> list(@QueryParam("page") int page) {
        logger.info("开始获取...");
        List<DungeonConsist> list = new ArrayList<DungeonConsist>();
        List<DungeonRelation> list1 = dungeonRelationService.getList(page);
        for(int i = 0; i< list1.size(); i++) {
            DungeonResource dungeonResource = dungeonResourceService.getResource(list1.get(i).getDungeon_id());
            DungeonRole dungeonRole = dungeonRoleService.getRole(list1.get(i).getRole_id());
            DungeonConsist dungeonConsist = dungeonConsistService.getDungeonConsist(dungeonResource, dungeonRole);
            list.add(dungeonConsist);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", list);
        return map;
    }

    @Path("/changeDungeon")
    @GET
    public Map<String, Object> changeDungeon(@QueryParam("id") int id, @QueryParam("isactive") int isactive, @QueryParam("range") int range) {
        logger.info("开始修改...");
        DungeonRelation dungeonRelation = dungeonRelationService.getRoleRelation(id);
        String result = String.valueOf(dungeonRoleService.save(dungeonRelation.getRole_id(), isactive, range));
        Map<String,Object> map = new HashMap<String, Object>();
        if(result != null && result.length()>0) {
            map.put("msg", "更新成功");
            map.put("code", "200");
        } else {
            map.put("code", "400");
            map.put("msg", "更新失败");
        }
        map.put("result", result);
        return map;
    }

    @Path("/deleteDungeon")
    @GET
    public Map<String, Object> deleteDungeon(@QueryParam("id") int id) {
        logger.info("开始删除...");
        DungeonRelation dungeonRelation = dungeonRelationService.getRoleRelation(id);
        logger.info("删除dungeon_resource...");
        String deleteResource = String.valueOf(dungeonResourceService.deleteResource(id));
        logger.info("删除dungeon_role...");
        String deleteRole = String.valueOf(dungeonRoleService.deleteRole(dungeonRelation.getRole_id()));
        logger.info("删除dungeon_role_relation...");
        String deleteRelation = String.valueOf(dungeonRelationService.deleteRelation(dungeonRelation.getId()));
        Map<String, Object> map = new HashMap<String, Object>();
        if(deleteRelation != null && deleteRelation.length()>0 && deleteResource != null && deleteResource.length()>0 && deleteRole != null && deleteRole.length()>0) {
            logger.info("全部删除成功...");
            map.put("code", "200");
            map.put("msg", "删除成功");
        } else {
            logger.info("删除失败...");
            map.put("code", "400");
            map.put("msg", "删除失败");
        }
        return map;
    }
}
