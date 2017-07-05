package com.flyingrain.translate.user.service.services.dao.model;

import java.util.Date;

/**
 * Created by wally on 7/5/17.
 */
public class UserInfoModel {

    private int id;

    private String name;

    private int gender;

    private String pet_name;

    private String school;

    private String phone;

    private int verify_phone;

    private int verify_email;

    private int age;

    private Date data_added;

    private Date last_modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPet_name() {
        return pet_name;
    }

    public void setPet_name(String pet_name) {
        this.pet_name = pet_name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getVerify_phone() {
        return verify_phone;
    }

    public void setVerify_phone(int verify_phone) {
        this.verify_phone = verify_phone;
    }

    public int getVerify_email() {
        return verify_email;
    }

    public void setVerify_email(int verify_email) {
        this.verify_email = verify_email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getData_added() {
        return data_added;
    }

    public void setData_added(Date data_added) {
        this.data_added = data_added;
    }

    public Date getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Date last_modified) {
        this.last_modified = last_modified;
    }
}
