package com.flyingrain.translate.framework.beanValidation.resolvers;

import com.flyingrain.translate.framework.beanValidation.ValidationConstraint;
import com.flyingrain.translate.framework.beanValidation.ValidationContext;
import com.flyingrain.translate.framework.beanValidation.ValidationResolver;
import com.flyingrain.translate.framework.beanValidation.annotations.BeanValidation;
import com.flyingrain.translate.framework.beanValidation.validations.DefaultValidations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wally on 9/5/17.
 */
public class DefaultValidationResolver implements ValidationResolver {

    private static final Logger logger = LoggerFactory.getLogger(DefaultValidationResolver.class);

    private ValidationContext context;

    public DefaultValidationResolver(ValidationContext context) {
        this.context = context;
    }

    @Override
    public List<ValidationConstraint> loadConstraints() {
        ValidationConstraint constraint = new DefaultValidations();
        BeanValidation beanValidation = null;
        if (context.getAnnotation() instanceof BeanValidation)
            beanValidation = (BeanValidation) context.getAnnotation();
        Class<? extends ValidationConstraint> constraints[] = beanValidation == null ? null : beanValidation.value();
        List<ValidationConstraint> result = new ArrayList<>();
        result.add(constraint);
        if (constraints != null) {
            result.addAll(Stream.of(constraints).map(constraintClass -> {
                try {
                    return constraintClass.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    logger.error("instance constraint failed!", e);
                    return null;
                }
            }).collect(Collectors.toList()));
        }
        return result;
    }
}
