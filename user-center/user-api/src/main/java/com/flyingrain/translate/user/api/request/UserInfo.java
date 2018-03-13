package com.flyingrain.translate.user.api.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 用户信息
 * Created by wally on 6/30/17.
 */
public class UserInfo {

    /**
     * 姓名
     */
    private String name;
    /**
     * 昵称
     */
    @NotBlank
    private String petName;
    /**
     * 性别1，男2，女
     */
    private int gender;
    /**
     * 微信号
     */
    private String weixin;
    /**
     * 年龄
     */
    private int age;
    /**
     * 密码
     */
    @NotBlank
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话
     */
    private String phone;
    /**
     * 学校
     */
    private String school;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPassword() {
        return password;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                ", name='" + name + '\'' +
                ", petName='" + petName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
