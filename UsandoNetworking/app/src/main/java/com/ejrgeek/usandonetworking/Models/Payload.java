package com.ejrgeek.usandonetworking.Models;

import com.google.gson.annotations.SerializedName;

public class Payload {

    @SerializedName("payload_type")
    private String mPayload;

    public Payload() {}

    public String getmPayload() {
        return mPayload;
    }

    public void setmPayload(String mPayload) {
        this.mPayload = mPayload;
    }
}
