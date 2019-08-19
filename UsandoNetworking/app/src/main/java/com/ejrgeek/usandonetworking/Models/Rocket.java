package com.ejrgeek.usandonetworking.Models;

import com.google.gson.annotations.SerializedName;

public class Rocket {

    @SerializedName("second_stage")
    private SecondStage mSecondStage;

    @SerializedName("rocket_name")
    private String mRocketName;

    public Rocket() {}

    public SecondStage getmSecondStage() {
        return mSecondStage;
    }

    public void setmSecondStage(SecondStage mSecondStage) {
        this.mSecondStage = mSecondStage;
    }

    public String getmRocketName() {
        return mRocketName;
    }

    public void setmRocketName(String mRocketName) {
        this.mRocketName = mRocketName;
    }
}
