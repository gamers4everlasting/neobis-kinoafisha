package com.example.olenburg.projectwo.model;

import com.example.olenburg.projectwo.model.Teatr;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeatrObject {
    @SerializedName("unmain")

    private List<Teatr> data;



    public List<Teatr> getData() {
        return data;
    }

    public void setData(List<Teatr> data) {
        this.data = data;
    }

}
