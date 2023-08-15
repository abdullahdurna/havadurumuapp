package com.example.havadurumuapp

import com.example.havadurumuapp.apiservices.WeatherService
import com.example.havadurumuapp.model.WeatherResponse

class WeatherRepository {

    private val service = ApiClient.retrofit.create(WeatherService::class.java)

    suspend fun getWeatherByCity(city: String, apiKey: String): WeatherResponse? {
        val response = service.getWeatherByCity(city,apiKey)
        return if (response.isSuccessful) response.body() else null
    }
}