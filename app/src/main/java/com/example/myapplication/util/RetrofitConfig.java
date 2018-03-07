package com.example.myapplication.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Android7 on 3/6/2018.
 */

public class RetrofitConfig {
    public static API_CALL getRetrofitObj() {
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.androidhive.info/json/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(API_CALL.class);
    }

}
