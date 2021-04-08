package com.soccer.myapplication;


import com.google.gson.annotations.SerializedName;

public class Club {

    @SerializedName("name")
    private String name;
    @SerializedName("code")

    private String code;
    @SerializedName("country")

    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}