package com.flyingrain.translate.auth.api.requests;

/**
 * 注册请求
 * Created by wally on 7/26/17.
 */
public class AuthRegisterRequest {

    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 昵称
     */
    private String petName;
    /**
     * 邮箱地址
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
    /**
     * 性别
     */
    private int gender;
    /**
     * 年龄
     */
    private int age;

    private String password;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
