package com.flyingrain.translate.framework.beanValidation.resolvers;

import com.flyingrain.translate.framework.beanValidation.ValidationConstraint;
import com.flyingrain.translate.framework.beanValidation.ValidationContext;
import com.flyingrain.translate.framework.beanValidation.ValidationResolver;
import com.flyingrain.translate.framework.beanValidation.validations.DefaultValidations;

import java.util.List;

/**
 * Created by wally on 9/5/17.
 */
public class DefaultValidationReslover implements ValidationResolver{

    private ValidationContext context;

    public DefaultValidationReslover(ValidationContext context) {
        this.context = context;
    }

    @Override
    public List<ValidationConstraint> loadConstraints() {
        ValidationConstraint constraint = new DefaultValidations();

        return null;
    }
}
