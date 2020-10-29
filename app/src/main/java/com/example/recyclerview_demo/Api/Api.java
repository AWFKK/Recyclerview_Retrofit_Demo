package com.example.recyclerview_demo.Api;



import com.example.recyclerview_demo.Model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {



    @GET("marvel")
    Call<List<Hero>> getHeroes();



}
