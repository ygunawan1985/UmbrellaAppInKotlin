package com.example.umbrellaappinkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.umbrellaappinkotlin.model.datasource.remote.retrofit.UrlConstants.Companion.ICON_URL
import com.example.umbrellaappinkotlin.model.datasource.remote.rxjava.Callback
import com.example.umbrellaappinkotlin.model.datasource.remote.rxjava.ForecastRepo
import com.example.umbrellaappinkotlin.model.datasource.remote.rxjava.WeatherRepo
import com.example.umbrellaappinkotlin.model.forecastresponse.Forecast
import com.example.umbrellaappinkotlin.model.forecastresponse.ForecastResponse
import com.example.umbrellaappinkotlin.model.weatherresponse.WeatherResponse
import java.text.SimpleDateFormat
import java.util.*

class CurrentWeather : AppCompatActivity(), Callback {

    private lateinit var ivWeatherIcon: ImageView
    private lateinit var tvCity: TextView
    private lateinit var tvWeatherDescription: TextView
    private lateinit var tvCurrentTemp: TextView
    private lateinit var tvHighLowTemps: TextView
    private lateinit var tvDateTime: TextView
    internal var forecastList = ArrayList<Forecast>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_weather)

        ivWeatherIcon = findViewById(R.id.ivWeatherIcon)
        tvCity = findViewById(R.id.tvCity)
        tvWeatherDescription = findViewById(R.id.tvWeatherDescription)
        tvCurrentTemp = findViewById(R.id.tvCurrentTemp)
        tvHighLowTemps = findViewById(R.id.tvHighLowTemps)
        tvDateTime = findViewById(R.id.tvDateTime)

        val receivedIntent = intent
        val zip = receivedIntent.getIntExtra("zipcode", 0)

        WeatherRepo.getWeather(this, zip, APPID)
        ForecastRepo.getForecast(this, zip, APPID)
    }

    override fun getWeatherResponse(weatherResponse: WeatherResponse) {

        //Retrieve weather icon then do Glide
        val icon = weatherResponse.weather?.get(0)?.icon
        val weatherIconUrl = ICON_URL + icon + "@2x.png"
        val currentTempInKelvin = weatherResponse.main?.temp
        val currentTemp = convertToFahrenheit(currentTempInKelvin!!)
        val highTemp = convertToFahrenheit(weatherResponse.main!!.tempMax!!)
        val lowTemp = convertToFahrenheit(weatherResponse.main!!.tempMin!!)
        val highandLowTemps = highTemp.toString() + "º/" + lowTemp + "º"

        val formatter = SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z")
        val strDate = formatter.format(Date())

        Glide.with(this).load(weatherIconUrl).into(ivWeatherIcon)
        tvCity.setText(weatherResponse.name)
        tvWeatherDescription.text = capitalizeWord(weatherResponse.weather?.get(0)?.description!!)
        tvCurrentTemp.text = currentTemp.toString() + "º"
        tvDateTime.text = strDate
        tvHighLowTemps.text = highandLowTemps
    }

    override fun getForecastResponse(forecastResponse: ForecastResponse) {

        val formatter = SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z")
        var date = Date()

        for (i in 0..39) {
            val strDate = formatter.format(date)
            val weatherDescription =
                capitalizeWord(forecastResponse.list?.get(i)?.weather?.get(0)?.description!!)
            val highTempInK = forecastResponse.list?.get(i)?.main?.tempMax
            val highTemp = convertToFahrenheit(highTempInK!!)
            val lowTempInK = forecastResponse.list?.get(i)?.main?.tempMin
            val lowTemp = convertToFahrenheit(lowTempInK!!)
            val weatherIconUrl = ICON_URL + forecastResponse.list!!.get(i).weather!!.get(0).icon + "@2x.png"

            forecastList.add(Forecast(strDate, weatherDescription, highTemp, lowTemp, weatherIconUrl))
            date = add3HoursToDate(date)
        }
    }

    fun convertToFahrenheit(temp: Float): Int {
        val tempInK = ((temp - 273) * (9.0 / 5.0) + 32).toFloat()

        return tempInK.toInt()
    }

    fun add3HoursToDate(date: Date): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.HOUR_OF_DAY, 3)
        return calendar.time
    }

    fun onCurrentWeatherClick(view: View) {
        val forecastIntent = Intent(this, ForecastActivity::class.java)
        val forecastBundle = Bundle()
        forecastBundle.putParcelableArrayList("forecastList", forecastList)
        forecastIntent.putExtras(forecastBundle)
        startActivity(forecastIntent)
    }

    companion object {

        val APPID = "f0d3041024e4f2d29366a34bc8b74f69"

        fun capitalizeWord(str: String): String {
            val words = str.split("\\s".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            var capitalizeWord = ""
            for (word in words) {
                val first = word.substring(0, 1)
                val afterfirst = word.substring(1)
                capitalizeWord += first.toUpperCase() + afterfirst + " "
            }
            return capitalizeWord.trim { it <= ' ' }
        }
    }
}