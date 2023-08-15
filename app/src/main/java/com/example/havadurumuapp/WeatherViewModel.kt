package com.example.havadurumuapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.havadurumuapp.model.WeatherResponse
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val repository = WeatherRepository()

    val weatherData = MutableLiveData<WeatherResponse?>()

    fun fetchWeatherByCity(city: String, apiKey: String) = viewModelScope.launch {
        val data = repository.getWeatherByCity(city, apiKey)
        weatherData.postValue(data)
    }
}
