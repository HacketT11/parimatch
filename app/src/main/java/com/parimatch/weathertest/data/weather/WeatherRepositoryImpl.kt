package com.parimatch.weathertest.data.weather

import retrofit2.Response

class WeatherRepositoryImpl(private val service: WeatherService) : WeatherRepository{

    override suspend fun getWeatherForecast(longtitude: Double, latitude: Double): Response<WeatherResponse> {
        return service.getWeather(latitude, longtitude)
    }
}