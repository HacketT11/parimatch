package com.parimatch.weathertest.data.weather

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService{

    @GET("data/2.5/onecall?exclude=hourly,minutely")
    suspend fun getWeather(@Query("lat") latitude: Double,
                           @Query("lon") longtitude: Double) : Response<WeatherResponse>
}