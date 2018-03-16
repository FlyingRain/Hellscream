package com.flyingrain.translate.dungeon.api;

import com.flyingrain.translate.dungeon.api.domain.DungeonInstance;
import com.flyingrain.translate.dungeon.api.requests.DungeonQueryRequest;
import com.flyingrain.translate.dungeon.api.requests.JoinRequest;
import com.flyingrain.translate.dungeon.api.requests.UploadTestRequest;
import com.flyingrain.translate.dungeon.api.responses.DungeonPlanResult;
import com.flyingrain.translate.dungeon.api.responses.JoinResult;
import com.flyingrain.translate.dungeon.api.responses.UploadResult;

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
     * 获取副本实例详情
     * @param instanceId
     * @return
     */
    @GET
    @Path("/dungeonInstance/{dungeonInstanceId}")
    DungeonInstance dungeonInstanceById(@PathParam("dungeonInstanceId")Integer instanceId);

    /**
     * 根据条件查询副本实例
     *
     * @param queryRequest
     * @return
     */
    @POST
    @Path("/dungeons")
    List<DungeonInstance> getDungeons(DungeonQueryRequest queryRequest);

    /**
     * 加入副本
     * @param joinRequest
     * @return
     */
    @POST
    @Path("/join")
    JoinResult joinDungeon(JoinRequest joinRequest);


    /**
     * 获取计划在副本中的信息
     * @param planId
     * @param userId
     * @return
     */
    @GET
    @Path("/getDungeonPlan")
    DungeonPlanResult getDungeonPlan(@QueryParam("planId")Integer planId,@QueryParam("userId")Integer userId);

    /**
     * 上传副本测试结果
     * @param request
     * @return
     */
    @POST
    @Path("/uploadTest")
    UploadResult uploadTest(UploadTestRequest request);
}
