package com.example.umbrellaappinkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.umbrellaappinkotlin.model.forecastresponse.Forecast
import kotlinx.android.synthetic.main.forecast_item.view.*

class ForecastListAdapter(val forecastList : List<Forecast>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.forecast_item, parent, false))

    override fun getItemCount(): Int = forecastList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.setValues(forecastList[position])

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setValues(forecast : Forecast) {
            Glide.with(itemView.context).load(forecast.weatherIconUrl).into(itemView.ivDailyIcon)
            itemView.tvDay.text = forecast.day
            itemView.tvDescription.text = forecast.weatherDescription
            itemView.tvHighTemp.text = "High: " + forecast.highTemp + "º"
            itemView.tvLowTemp.text = "Low: " + forecast.lowTemp + "º"
        }

    }
}