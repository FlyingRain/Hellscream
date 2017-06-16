package com.flyingrain.translate.plan.api.intf;

import com.flyingrain.translate.plan.api.request.PlanRequest;
import com.flyingrain.translate.plan.api.response.ModifyResult;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.Result;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by wally on 4/25/17.
 */
@Path("/plan")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PlanManagerResource {
    /**
     * 制定计划
     * @param planRequest 计划内容
     * @return
     */
    @POST
    @Path("/make")
    Integer makePlan(PlanRequest planRequest);

    /**
     * 查询计划
     * @param planId 计划Id
     * @param userId 用户ID
     * @return 计划列表
     */
    @GET
    @Path("/query")
    List<Plan> queryPlan(@QueryParam("planId") Integer planId,@QueryParam("userId")Integer userId);

    /**
     * 修改计划
     * @param planRequest 修改后的计划
     * @return 修改结果
     */
    @POST
    @Path("/modify")
    ModifyResult modifyPlan(PlanRequest planRequest);
}
