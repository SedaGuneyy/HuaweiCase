package com.soccer.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface JsonPlaceHolderApi {

    @GET("f3dbc091")
    Call<Example> getPosts();

}