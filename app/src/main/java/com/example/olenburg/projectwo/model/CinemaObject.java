package com.example.olenburg.projectwo.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CinemaObject {
    @SerializedName("result")
    private List<Cinema> data;



    public List<Cinema> getData() {
        return data;
    }

    public void setData(List<Cinema> data1) {
        this.data = data1;
    }

}
