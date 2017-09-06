package com.flyingrain.translate.framework.beanValidation;

import com.flyingrain.translate.framework.beanValidation.resolvers.DefaultValidationResolver;
import com.flyingrain.translate.framework.beanValidation.resolvers.ValidatorResolver;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by wally on 9/5/17.
 */
public class ValidationFactory {

    public static List<ValidationConstraint> loadConstraints(ValidationContext validationContext,ApplicationContext applicationContext){
        DefaultValidationResolver defaultValidationResolver = new DefaultValidationResolver(validationContext,applicationContext);
        ValidatorResolver validatorResolver = new ValidatorResolver(validationContext,applicationContext);
        List<ValidationConstraint> defaultConstraints = defaultValidationResolver.loadConstraints();
        defaultConstraints.addAll(validatorResolver.loadConstraints());
        return defaultConstraints;
    }

}
