package com.flyingrain.translate.framework.beanValidation.test.resources;

import com.flyingrain.translate.framework.beanValidation.test.resources.domain.TestDomain;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by wally on 9/6/17.
 */
@Path("/test")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TestBeanValidation {

    @Path("/beanValidation")
    @POST
    String test(TestDomain domain);

}
