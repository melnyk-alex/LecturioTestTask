package com.example.ua.testtask.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 */
public class Example {

    @SerializedName("data")
    @Expose
    private Data data;

    public Example() {
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
