package com.example.kazi.igtandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("jackpot")
    @Expose
    private Integer jackpot;
    @SerializedName("date")
    @Expose
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getJackpot() {
        return jackpot;
    }

    public void setJackpot(Integer jackpot) {
        this.jackpot = jackpot;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
