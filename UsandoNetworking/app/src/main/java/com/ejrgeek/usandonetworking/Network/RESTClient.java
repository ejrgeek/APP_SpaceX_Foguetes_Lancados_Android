package com.ejrgeek.usandonetworking.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RESTClient {

    public static APIService getService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(APIService.class);
    }

}
