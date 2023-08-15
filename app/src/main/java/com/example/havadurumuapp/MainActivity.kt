package com.example.havadurumuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: WeatherViewModel
    private lateinit var textView: TextView // Ekranınızdaki TextView bileşenini temsil eden bir referans oluşturduk.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView) // ID'si "textView" olan bileşeni alıp, önceden oluşturduğumuz referansa atadık.

        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        viewModel.weatherData.observe(this, Observer { weatherResponse ->
            if(weatherResponse != null) {
                val displayText = "Ana Durum: ${weatherResponse.main}\nAçıklama: ${weatherResponse.description}"
                textView.text = displayText
            } else {
                textView.text = "Hava durumu bilgisi alınamadı."
            }
        })

        viewModel.fetchWeatherByCity("Istanbul", "YOUR_API_KEY") // "YOUR_API_KEY" kısmını OpenWeatherMap'ten aldığınız anahtarla değiştirin.
    }
}
