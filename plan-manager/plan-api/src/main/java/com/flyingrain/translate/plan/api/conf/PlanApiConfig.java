package com.flyingrain.translate.plan.api.conf;

import com.flyingrain.translate.framework.wrapper.impl.RestWrapper;
import com.flyingrain.translate.plan.api.intf.PlanDerivativeResource;
import com.flyingrain.translate.plan.api.intf.PlanManagerResource;
import com.flyingrain.translate.plan.api.intf.TaskResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wally on 18-3-17.
 */
@Configuration
public class PlanApiConfig {

    @Bean
    @Autowired
    TaskResource taskResource(RestWrapper restWrapper) {
        return restWrapper.wrapper(TaskResource.class);
    }

    @Bean
    @Autowired
    PlanManagerResource planManagerResource(RestWrapper restWrapper) {
        return restWrapper.wrapper(PlanManagerResource.class);
    }


    @Bean
    @Autowired
    PlanDerivativeResource planDerivativeResource(RestWrapper restWrapper) {
        return restWrapper.wrapper(PlanDerivativeResource.class);
    }
}
