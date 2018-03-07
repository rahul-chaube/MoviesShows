package com.example.myapplication.util;

import com.example.myapplication.model.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Android7 on 3/6/2018.
 */

public interface API_CALL {
    @GET("movies.json")
    Call<List<MovieResponse>> groupList();
}
