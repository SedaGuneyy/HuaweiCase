package com.soccer.myapplication;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("name")

    private String name;
    @SerializedName("clubs")

    private List<Club> clubs = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

}