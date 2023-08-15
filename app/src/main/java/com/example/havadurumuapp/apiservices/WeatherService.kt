package com.example.havadurumuapp.apiservices

import com.example.havadurumuapp.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("weather")
    suspend fun getWeatherByCity(@Query("q") city: String, @Query("appid") apiKey: String): Response<WeatherResponse>
}