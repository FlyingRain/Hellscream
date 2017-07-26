package com.flyingrain.translate.auth.api.requests;

/**
 * 登陆请求
 * Created by wally on 7/26/17.
 */
public class LoginRequest {

    private String petName;

    private String email;

    private String phone;

    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
