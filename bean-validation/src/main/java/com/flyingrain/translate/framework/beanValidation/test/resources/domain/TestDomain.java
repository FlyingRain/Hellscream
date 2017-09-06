package com.flyingrain.translate.framework.beanValidation.test.resources.domain;

import javax.validation.constraints.NotNull;

/**
 * Created by wally on 9/6/17.
 */
public class TestDomain {

    @NotNull
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
