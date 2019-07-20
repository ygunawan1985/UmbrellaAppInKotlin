package com.example.umbrellaappinkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var etZip : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etZip = findViewById(R.id.etZip)

    }

    fun onClick(view : View) {

        val zip = Integer.parseInt(etZip.text.toString())
        val toCurrentWeatherIntent = Intent(this, PresentWeather::class.java)
        toCurrentWeatherIntent.putExtra("zipcode", zip)
        startActivity(toCurrentWeatherIntent)
    }
}
