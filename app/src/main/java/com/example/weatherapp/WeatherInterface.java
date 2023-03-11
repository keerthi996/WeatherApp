package com.example.weatherapp;

import com.example.weatherapp.ModelInJava.ModelResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherInterface {
    @GET("weather")
    Call<ModelResponse> getWeather(@Query("q") String cityName,
                                   @Query("appid") String apikey,
                                   @Query("units") String unit);

}
