package com.flyingrain.translate.framework.beanValidation.test.resources.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.framework.beanValidation.annotations.BeanValidation;
import com.flyingrain.translate.framework.beanValidation.test.resources.TestBeanValidation;
import com.flyingrain.translate.framework.beanValidation.test.resources.domain.TestDomain;
import com.flyingrain.translate.framework.beanValidation.test.resources.validations.DomainValidation;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 9/6/17.
 */
@Component
@Resource
public class TestBeanValidationImpl implements TestBeanValidation{

    @Override
    @BeanValidation(DomainValidation.class)
    public String test(TestDomain domain) {
        return "success!";
    }
}
