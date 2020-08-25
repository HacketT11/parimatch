package com.parimatch.weathertest.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.parimatch.weathertest.R
import com.parimatch.weathertest.screens.main.domain.WeatherDay
import kotlinx.android.synthetic.main.item_weather.view.*

class WeatherAdapter(private val list: List<WeatherDay>) : RecyclerView.Adapter<WeatherAdapter.WeatherHolder>() {

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WeatherHolder(inflater.inflate(R.layout.item_weather, parent, false))
    }

    class WeatherHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(weatherDay: WeatherDay) = with(itemView) {
            humidityTv.text = itemView.context.getString(R.string.humidity, weatherDay.humidity.toString())
            temperatureTv.text = itemView.context.getString(R.string.celsium, weatherDay.temperature.toString())
            dateTv.text = weatherDay.date
            windSpeedTv.text = weatherDay.windSpeed.toString()
            titleTv.text = weatherDay.description
        }
    }
}