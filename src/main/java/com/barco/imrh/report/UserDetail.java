package com.barco.imrh.report;

import com.google.gson.Gson;
import java.util.UUID;

public class UserDetail {

    private Long id;
    private String userName;
    private String fatherName;
    private String IdentityNumber;
    private String gender;
    private String country;
    private String imageUrl;

    public UserDetail() {
        this(1000L, "Nabeel Ahmed Jamil", "Jamil Ur Rehman",
                UUID.randomUUID().toString(),"G", "Qatar",
        "https://avatars.githubusercontent.com/u/24192325?s=400&u=eb9d26871b1b873497f4f71df76d70fa7e046194&v=4");
    }

    public UserDetail(Long id, String userName, String fatherName,
        String identityNumber, String gender, String country, String imageUrl) {
        this.id = id;
        this.userName = userName;
        this.fatherName = fatherName;
        IdentityNumber = identityNumber;
        this.gender = gender;
        this.country = country;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFatherName() {
        return fatherName;
    }
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getIdentityNumber() {
        return IdentityNumber;
    }
    public void setIdentityNumber(String identityNumber) {
        IdentityNumber = identityNumber;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}