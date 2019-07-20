package com.example.umbrellaappinkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.umbrellaappinkotlin.model.forecastresponse.Forecast

class ForecastActivity : AppCompatActivity() {

    lateinit var rvForecast : RecyclerView
    lateinit var forecastList : List<Forecast>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        rvForecast = findViewById(R.id.rvForecast)
        rvForecast.layoutManager = LinearLayoutManager(this)

        val receivedIntent : Intent = intent
        val receivedBundle : Bundle? = receivedIntent.extras
        forecastList = receivedBundle?.getParcelableArrayList("forecastList")!!

        val forecastListAdapter = ForecastListAdapter(forecastList)
        rvForecast.adapter = forecastListAdapter
    }
}
