package com.parimatch.weathertest.data.weather

import retrofit2.Response

interface WeatherRepository{

    private companion object{
        const val DEFAULT_COUNT = 16
    }

    suspend fun getWeatherForecast(longtitude: Double, latitude: Double): Response<WeatherResponse>
}