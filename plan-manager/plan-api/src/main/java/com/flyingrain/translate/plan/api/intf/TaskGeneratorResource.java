package com.flyingrain.translate.plan.api.intf;

import com.flyingrain.translate.plan.api.response.Result;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by wally on 4/26/17.
 */
@Path("plan")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TaskGeneratorResource {

    /**
     * 生成用户的每日计划
     * @return 结果
     */
    @Path("/generate/dayPlan")
    Result<String> generate();

}
