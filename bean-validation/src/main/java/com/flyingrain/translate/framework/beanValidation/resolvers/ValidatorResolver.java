package com.flyingrain.translate.framework.beanValidation.resolvers;

import com.flyingrain.translate.framework.beanValidation.ValidationConstraint;
import com.flyingrain.translate.framework.beanValidation.ValidationContext;
import com.flyingrain.translate.framework.beanValidation.ValidationResolver;
import com.flyingrain.translate.framework.beanValidation.annotations.Validator;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wally on 9/5/17.
 */
public class ValidatorResolver implements ValidationResolver{

    private final ValidationContext context;

    private final ApplicationContext applicationContext;

    public ValidatorResolver(ValidationContext context,ApplicationContext applicationContext) {
        this.context = context;
        this.applicationContext = applicationContext;
    }

    @Override
    public List<ValidationConstraint> loadConstraints() {
        Map<String,Object> beans = applicationContext.getBeansWithAnnotation(Validator.class);
        return  beans.entrySet().stream().map(Map.Entry::getValue).filter(bean->{
            Validator validator = bean.getClass().getAnnotation(Validator.class);
            if(validator.target() == Void.class){
                return true;
            }
            return validator.target()==context.getTargetClass()&&context.getMethodName().equals(validator.methodName())&&bean instanceof ValidationConstraint;
        }).map(object->(ValidationConstraint)object).collect(Collectors.toList());
    }
}
