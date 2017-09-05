package com.flyingrain.translate.framework.beanValidation;

import java.util.List;

/**
 * Created by wally on 9/5/17.
 */
public interface ValidationResolver {

    List<ValidationConstraint> loadConstraints();
}
