package com.example.pureweather.service;

import com.example.pureweather.model.Weather_App;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Weather_Api {
    @GET("weather")
    Call<Weather_App> getWeather(@Query("q")String city, @Query("appid")String apiKey);

}
