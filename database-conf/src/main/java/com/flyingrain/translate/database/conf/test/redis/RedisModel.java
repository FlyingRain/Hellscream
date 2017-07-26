package com.flyingrain.translate.database.conf.test.redis;

/**
 * Created by wally on 7/26/17.
 */
public class RedisModel {

    private String name;

    private String age;

    public RedisModel(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public RedisModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
