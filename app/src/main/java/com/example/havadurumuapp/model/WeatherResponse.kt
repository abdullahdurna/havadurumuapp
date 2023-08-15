package com.example.havadurumuapp.model

data class WeatherResponse(
    val main: Main,
    val weather: List<Weather>
)

data class Main(val temp: Float, val pressure: Int, val humidity: Int)
data class Weather(val main: String, val description: String)
