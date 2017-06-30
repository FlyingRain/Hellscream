package com.flyingrain.translate.user.api.response;

/**
 * Created by wally on 6/30/17.
 */
public class UserInfo {

    private String name;

    private int age;

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

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
