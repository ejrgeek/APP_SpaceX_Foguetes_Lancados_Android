package com.ejrgeek.usandonetworking.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SecondStage {

    @SerializedName("payloads")
    private ArrayList<Payload> payloads;

    public SecondStage() {}

    public ArrayList<Payload> getPayloads() {
        return payloads;
    }

    public void setPayloads(ArrayList<Payload> payloads) {
        this.payloads = payloads;
    }

    @Override
    public String toString() {
        return "SecondStage{" +
                "payloads=" + payloads +
                '}';
    }
}
