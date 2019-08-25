package com.ejrgeek.usandonetworking.Network;

import com.ejrgeek.usandonetworking.Models.RocketModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    String URL_BASE = "https://api.spacexdata.com/v3/";
    //https://api.spacexdata.com/v3/launches/latest

    @GET("launches")
    Call<List<RocketModel>> getRockets(@Query("order") String order);

}
