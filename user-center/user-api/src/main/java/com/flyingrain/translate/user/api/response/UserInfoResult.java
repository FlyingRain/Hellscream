package com.flyingrain.translate.user.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by wally on 6/30/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoResult {

    private int userId;

    private String name;

    private int age;

    private String weixin;

    private String phone;

    private String email;

    private String school;

    private int verifyPhone;

    private int verifyEmail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getAge() {
        return age;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfoResult{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weixin='" + weixin + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", school='" + school + '\'' +
                ", verifyPhone=" + verifyPhone +
                ", verifyEmail=" + verifyEmail +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVerifyPhone() {
        return verifyPhone;
    }

    public void setVerifyPhone(int verifyPhone) {
        this.verifyPhone = verifyPhone;
    }

    public int getVerifyEmail() {
        return verifyEmail;
    }

    public void setVerifyEmail(int verifyEmail) {
        this.verifyEmail = verifyEmail;
    }
}
