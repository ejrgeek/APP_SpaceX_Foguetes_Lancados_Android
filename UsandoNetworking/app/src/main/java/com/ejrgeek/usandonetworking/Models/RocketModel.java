package com.ejrgeek.usandonetworking.Models;


import com.google.gson.annotations.SerializedName;

public class RocketModel {

    @SerializedName("rocket")
    private Rocket rocket;

    @SerializedName("launch_year")
    private String mLauchYear;

    @SerializedName("launch_success")
    private boolean mStatusLaunch;

    public RocketModel() {}

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public String getmLauchYear() {
        return mLauchYear;
    }

    public void setmLauchYear(String mLauchYear) {
        this.mLauchYear = mLauchYear;
    }

    public boolean ismStatusLaunch() {
        return mStatusLaunch;
    }

    public void setmStatusLaunch(boolean mStatusLaunch) {
        this.mStatusLaunch = mStatusLaunch;
    }

    @Override
    public String toString() {
        return "RocketModel{" +
                "rocket=" + rocket +
                ", mLauchYear='" + mLauchYear + '\'' +
                ", mStatusLaunch=" + mStatusLaunch +
                '}';
    }
}
